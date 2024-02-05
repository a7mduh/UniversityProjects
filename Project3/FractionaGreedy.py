def GreedyFractional(prices, weights, MaxWeight):
    length=len(prices)
    fractions=[] #this list will have the price/weight of all the items
    sortedIndicies=[] #this will have the sorted indicies of the items in terms of price/weight

    for i in range(length): # appending the price/weight in fractions
        fractions.append(prices[i]/weights[i]) 

    def ratios(i): return fractions[i] #function to use in sorting
    sortedIndicies=sorted(range(length), key=ratios, reverse=True) #sorting the indicies in decsending order
    print(sortedIndicies)
    consumedWeight=0 #used capacity in the bag
    totalPrice=0 #final optimal price
    for i in  sortedIndicies:#loop to add items in the bag
        if consumedWeight+weights[i] <= MaxWeight:
            consumedWeight+=weights[i]
            totalPrice+=prices[i]
        else: #else part to add the last item partially
            temp=(MaxWeight-consumedWeight)/weights[i]
            consumedWeight=MaxWeight
            totalPrice+=(prices[i]*temp)
            break
    print("The total price of the items in the bag is:", totalPrice, "$")
GreedyFractional([60,100,120], [20, 50, 30], 50)
