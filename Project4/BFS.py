# -*- coding: utf-8 -*-
"""
Created on Tue Apr 18 20:29:49 2023


@author: rekog
"""


import networkx as nx
import sys
import queue
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
colors={}#dictonaries for the nodes data
distances={}
preds={}
def BFS(G, s): #BFS algorith,
    for u in G.nodes:
        if u==s:
            continue
        colors[u]='White'
        distances[u]=sys.maxsize
        preds[u]=None
    colors[s]='Gray'
    distances[s]=0
    preds[s]=None
    
    Q=queue.Queue(20)
    Q.put(s)
    while not Q.empty():
        u=Q.get()
        for v in G.adj[u]:
            if colors[v]=='White':
                colors[v]='Gray'
                distances[v]=distances[u]+G[u][v]["weight"]
                preds[v]=u
                Q.put(v)
        colors[u]='Black'
        print(u) #to print the traversal order
def Print_Path(G, s, v): #printing the path from a node to other by BFS by using the constructed tree
    if v==s:
        print(s)
    elif preds[v]==None:
        print("no path from ", s, " to ", v, " exits")
    else:
        Print_Path(G, s, preds[v])
        print(v)
BFS(G, nodes[0])