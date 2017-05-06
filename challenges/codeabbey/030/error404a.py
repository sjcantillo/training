"""This function reverse a string."""


def reversestring(data):
    """Reverse a string."""
    res = ""
    for i in data:
        res = i + res
    print res
