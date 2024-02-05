from collections import Counter

class Node(): #this class is to use node in the tree
    def __init__(self, leftChild=None, rightChild=None):
        self.leftChild = leftChild
        self.rightChild = rightChild

    def children(self): #children of a node
        return self.leftChild, self.rightChild

def huffman_code_tree(node, binString=''): #get the code of a letter
    if type(node) is str:
        return {node: binString}
    (l, r) = node.children()
    d = dict()
    d.update(huffman_code_tree(l, binString + '0'))
    d.update(huffman_code_tree(r, binString + '1'))
    return d

def TreeConstruction(freqNode): #building the tree 
    while len(freqNode)>1:
        (letter, freq)=freqNode[-1]
        (letter1, freq1)=freqNode[-2]
        freqNode=freqNode[:-2]
        node=Node(letter, letter1)
        freqNode.append((node, freq+freq1))
        freqNode=sorted(freqNode, key=lambda x:x[1], reverse=True )
    return freqNode[0][0]

msg="ABBABACDCBABCABACDBCDEACCACECA" 
freqcsDict=dict(Counter(msg))
freqcsDict=sorted(freqcsDict.items(), key=lambda x:x[1], reverse=True )
rootNode=TreeConstruction(freqcsDict)
finalBinCode=huffman_code_tree(rootNode)
print(finalBinCode)





    
