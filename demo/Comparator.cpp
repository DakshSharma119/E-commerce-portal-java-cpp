#include <bits/stdc++.h>
using namespace std;
#include "Comparator.h"

Comparator::Comparator(int index)
{ // stores index as we sort a vector so we should know on what basis(i.e ref to which ind)
    this->index = index;
}
bool Comparator::operator()(vector<string> v1, vector<string> v2) // cmp which sorts on basis of particular index of vector
{
    if (index == 4) // that is with respect to price sorting
    {
        return stoi(v1[index]) < stoi(v2[index]); // convert to int and then compare
    }
    else if (index == 3) // any other parameter
    {
        return v1[index] < v2[index];
    }
    else if (index == 5)
    {

        return stoi(v1[index]) < stoi(v2[index]); // convert to int and then compare
    }
    else if (index == 2)
    {

        return v1[index] < v2[index]; //  compare
    }
    else{
        return false;
    }
}
