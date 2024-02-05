# importing packages
from mpi4py import MPI
import random
import time 
# This function will give each process its job
def func(rank, n):
    # Root process
    if rank == 0: 
        # Generate the random list at the root process
        random_integers = [random.randint(0, 1000000) for _ in range(1000000)]
        # Initial time
        time1 = time.time()
        # Send this array to all the processes
        for i in range(1, n): 
            comm.send(random_integers, dest=i)
        # Finding the sub-array to be sorted at root process
        start, end = start_end_finder(rank, n, len(random_integers))
        # Making the result array and initially we put the sub-array of the root process
        result = random_integers[start: end]
        # Sorting the sub-array of the root process
        merge_sort(result)
        # Receiving the results from the other processes and adding them to the result list
        for i in range(1, n):
            sorted_sub_arr = comm.recv(source=i)
            result = merge(result, sorted_sub_arr)  # Merge each sorted sub-array as it arrives
         # Final time
        time2 = time.time()
        print("Time taken to sort: ",time2 - time1)
        print("First 100 elements of the sorted array:", result[:100])
    
    # Other processes 
    else:
        # Receiving the array from the root process
        arr = comm.recv(source=0)
        # Dividing the job (finding the sub-array for each process)
        start, end = start_end_finder(rank, n, len(arr))
        sub_arr = arr[start:end]
        # Sorting the sub-array
        merge_sort(sub_arr)
        # Sending the sorted array to the root process
        comm.send(sub_arr, dest=0)

# Function to divide the array based on each process's rank
def start_end_finder(rank, n, size):
    chunk = size // n  
    start = chunk * rank 
    end = start + chunk
    if rank == n - 1:
        end = size  # Make sure the last process covers the remainder
    return start, end

# Merge sort algorithm
def merge_sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left = arr[:mid]
        right = arr[mid:]

        merge_sort(left)
        merge_sort(right)

        i = j = k = 0
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                arr[k] = left[i]
                i += 1
            else:
                arr[k] = right[j]
                j += 1
            k += 1

        while i < len(left):
            arr[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            arr[k] = right[j]
            j += 1
            k += 1

def merge(left, right):
    result = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result.extend(left[i:])
    result.extend(right[j:])
    return result

if __name__ == '__main__':
    comm = MPI.COMM_WORLD #default comminucator 
    rank = comm.Get_rank() #rank of the current process
    n = comm.Get_size() #number of processes

    func(rank, n)

