
#include <bits/stdc++.h>
#include "../ecomm/Portal.h"

using namespace std;
#ifndef DEMOPORTAL_H
#define DEMOPORTAL_H
class DemoPortal : public Portal
{

private:
    int reqID;
    const int portalID = 1;
    string category;
    string sortOrder;
    string productID;
    int quantity;
    int index;
    ofstream MyFile;
    vector<vector<string>> reqRecord;
    // ofstream MyFile;

public:
    void splitting(string s, vector<string> &arr);
    DemoPortal();
    void processUserCommand(string s);
    // vector<string> split(string s);

    void checkResponse();
};
#endif
