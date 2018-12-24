# python3

import sys
import threading

sys.setrecursionlimit(10 ** 7)  # max depth of recursion
threading.stack_size(2 ** 25)  # new thread will get stack of such size


class TreeHeight:
    """Computes height of a given tree.

    Height of a (rooted) tree is the maximum depth of a node, or the maximum
    distance from a leaf to the root.

    Samples:
    >>> tree = TreeHeight()
    >>> tree.n = 5
    >>> tree.parent = [4, -1, 4, 1, 1]
    >>> tree.compute_height()
    3
    >>> # Explanation:
    >>> # The input means that there are 5 nodes with numbers from 0 to 4,
    >>> # node 0 is a child of node 4, node 1 is the root, node 2 is a child of
    >>> # node 4, node 3 is a child of node 1 and node 4 is a child of node 1.
    >>> #
    >>> #       root
    >>> #         1
    >>> #        /|
    >>> #       3 4
    >>> #      /  |
    >>> #     0   2
    >>> #
    >>> tree = TreeHeight()
    >>> tree.n = 5
    >>> tree.parent = [-1, 0, 4, 0, 3]
    >>> tree.compute_height()
    4
    >>> # Explanation:
    >>> # The input means that there are 5 nodes with numbers from 0 to 4,
    >>> # node 0 is the root, node 1 is a child of node 0, node 2 is a child of
    >>> # node 4, node 3 is a child of node 0 and node 4 is a child of node 3.
    >>> #
    >>> #       root
    >>> #         1
    >>> #        /|
    >>> #       1 3
    >>> #         |
    >>> #         4
    >>> #         |
    >>> #         2
    """

    def __init__(self):
        self.n = 0
        self.parent = []
        self.cache = []

    def read(self):
        """Reads data from standard input."""
        self.n = int(sys.stdin.readline())
        self.parent = list(map(int, sys.stdin.readline().split()))
        self.cache = [0] * self.n

    def path_len(self, node_id):
        """Returns path length from given node to the root."""
        parent = self.parent[node_id]
        if parent == -1:
            return 1

        if self.cache[node_id]:
            return self.cache[node_id]

        self.cache[node_id] = 1 + self.path_len(self.parent[node_id])
        return self.cache[node_id]

    def compute_height(self):
        """Computes the tree height."""
        return max([self.path_len(i) for i in range(self.n)])


def main():
    tree = TreeHeight()
    tree.read()
    print(tree.compute_height())


threading.Thread(target=main).start()
