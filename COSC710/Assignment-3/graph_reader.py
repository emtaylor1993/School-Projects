"""
This script reads in a weighted graph from a file. It sorts node
descendingly by their degree, betweenness, closeness centralities
and their clustering coefficient. It also removes the top k nodes 
and produces new graphs.

Author:        E. Taylor
Date Created:  February 24, 2025
Date Modified: February 24, 2025
Dependencies:  networkx
"""

import networkx as nx;

# Read Graph contents from text file.
def read_graph(filename):
    with open(filename, "r") as file:
        first_line = file.readline().split()
        nodes = int(first_line[0])
        is_directed = int(first_line[1] == 1)
        
        if is_directed:
            graph = nx.DiGraph()
        else:
            graph = nx.Graph()
                    
        for line in file:
            u, v, w = map(int, line.split())
            graph.add_edge(u, v, weight=w)
    return graph

# Calculate Graph centralities.
def calculate_centrality(graph):
    degree = dict(graph.degree())
    betweenness = nx.betweenness_centrality(graph, weight="weight")
    closeness = nx.closeness_centrality(graph, distance="weight")
    clustering_coefficient = nx.clustering(graph)
    
    return {
        "degree": sorted(degree, key=degree.get, reverse=True),
        "betweenness": sorted(betweenness, key=betweenness.get, reverse=True),
        "closeness": sorted(closeness, key=closeness.get, reverse=True),
        "clustering": sorted(clustering_coefficient, key=clustering_coefficient.get, reverse=True)
    }

# Remove top k nodes from graph and produce new graph.
def remove_top_k_nodes(graph, sorted_nodes, k, output_prefix):
    for centrality_type, nodes in sorted_nodes.items():
        top_k_nodes = nodes[:k]
        new_graph = graph.copy()
        new_graph.remove_nodes_from(top_k_nodes)
        output_file = f"{output_prefix}_{centrality_type}.txt"
        write_graph(new_graph, output_file)

# Write graph to file output.
def write_graph(graph, filename):
    with open(filename, "w") as file:
        file.write(f"{len(graph.nodes())} {'1' if graph.is_directed() else '0'}\n")
        for u, v, data in graph.edges(data=True):
            file.write(f"{u} {v} {data['weight']}\n")
            
if __name__ == "__main__":
    input_file = "graph.txt"
    k = int(input("Enter a positive value for k: "))
    
    while (k <= 0):
        print("Invalid entry for k.")
        k = int(input("Enter a positive value for k: "))
        
    graph = read_graph(input_file)
    sorted_nodes = calculate_centrality(graph)
    remove_top_k_nodes(graph, sorted_nodes, k, "output")
    print("Graphs process, constructed and saved to output files.")