def construct_tree(tree_string, search_index=0, tree_index=0):    
    number = int(tree_string[search_index])
    return [number, *construct_tree(
        tree_string, 
        search_index=search_index+1,
        tree_index=tree_index+1)]


def test_construct_tree():
    assert construct_tree(
        tree_string='4(2)'
    ) == [4, 2]
    # assert construct_tree(
    #     tree_string='4(2(3)(1))(6(5))'
    # ) == [4, 2, 6, 3, 1, 5]
