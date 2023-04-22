#include <bits/stdc++.h>
#include "demo/DemoPortal.h"
#include "ecomm/Portal.h"
using namespace std;

int main()
{
    // Read terminal
    // Write portal to platform
    // Read check from terminal--Read from platform to portal
    // Output to terminal
    Portal *p1 = new DemoPortal();
    while (true)
    {
        string s;
        getline(cin, s);
        if (s[0] == 'C')
        {
            p1->checkResponse();
        }
        else
        {
            p1->processUserCommand(s);
        }
    }
}
