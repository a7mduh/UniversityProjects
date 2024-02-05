# -*- coding: utf-8 -*-
"""
Created on Tue Apr 18 22:20:15 2023


@author: rekog
"""


import networkx as nx


G=nx.Graph() #constructing the graph
G.add_edge("A", "B", weight=5)
G.add_edge("A", "D", weight=2)
G.add_edge("B", "E", weight=9)
G.add_edge("D", "E", weight=7)
G.add_edge("F", "B", weight=1)
G.add_edge("E", "F", weight=4)
G.add_edge("C", "F", weight=3)
G.add_edge("F", "H", weight=13)
G.add_edge("F", "G", weight=7)
G.add_edge("H", "G", weight=5)
nodes=list(G.nodes)
colors={} #dictonaries for the nodes data
distances={}
preds={}
finishs={}
time=0
stack=[] #stack for topological sort


G1=nx.DiGraph() #directed graph to test the the topoligcal sort
G1.add_edge("B", "E")
G1.add_edge("B", "C")
G1.add_edge("E", "A")
G1.add_edge("E", "C")
G1.add_edge("A", "C")
G1.add_edge("C", "D")
G1.add_edge("A","D")


def DFS_Visit(G, u): 
    global time
    time+=1
    distances[u]=time
    colors[u]='gray'
    for v in G.adj[u]:
        if colors[v]=='white':
            preds[v]=u
            DFS_Visit(G,v)
    colors[u]='black'
    time+=1
    finishs[u]=time
    stack.append(u)
def DFS (G):
    for u in G.nodes:
        colors[u]='white'
        preds[u]=None    
    
    for u in G.nodes:
        if colors[u]=='white':
            DFS_Visit(G, u)
def topological_sort(G):
    DFS(G)
    for i in range(len(stack)):
        print(stack[-1])
        stack.pop(-1)
topological_sort(G1)
