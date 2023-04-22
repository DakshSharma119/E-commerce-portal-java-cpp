
#include <bits/stdc++.h>
#include "../ecomm/Portal.h"
#include "Comparator.h"
using namespace std;
#include "DemoPortal.h"

void DemoPortal::splitting(string s, vector<string> &arr) // splitting logic
{                                                         // vector passed by ref so string is split and seperate words are stored in vector
    s = s + ' ';
    string w = "";
    for (int i = 0; i < s.size(); i++)
    {
        if (s[i] == ' ')
        {
            arr.push_back(w);
            w = "";
        }
        else
        {
            w += s[i];
        }
    }
}

DemoPortal::DemoPortal() : reqID(100)
{
    MyFile.open("PortalToPlatform.txt"); // File reading
}

void DemoPortal::processUserCommand(string s)
{
    // ofstream MyFile;
    // MyFile.open("PortalToPlatform.txt");
    if (s[0] == 'L')
    {
        string category;
        string sortOrder;
        if (s[5] == 'B')
        {
            category = "Book";
            sortOrder = s.substr(10);
        }
        else
        {
            category = "Mobile";
            sortOrder = s.substr(12);
        }

        // cout << portalID <<" "<<this->reqID++ ;
        // vector<string> v={portalID,reqID,"List",category};
        reqRecord.push_back({to_string(portalID), to_string(reqID), "List", category, sortOrder});
        MyFile << portalID << " " << this->reqID++ << " List " << category << endl;
        // Write to PortalToPlatform
    }
    else if (s[0] == 'B')
    {
        string productID;
        int quantity;
        int index;
        for (int i = 4; i < s.length(); i++)
        {
            if (s[i] == ' ')
            {
                index = i;
                break;
            }
        }
        productID = s.substr(4, index - 4);
        string quant = s.substr(index + 1);
        quantity = stoi(quant);
        // file write
        //  vector<string> v={portalID,reqID,"Buy",productID,quantity};
        //  reqRecord.push_back(v);
        reqRecord.push_back({to_string(portalID), to_string(reqID), "Buy", productID, to_string(quantity)});
        MyFile << portalID << " " << this->reqID++ << " Buy " << productID << " " << quantity << endl;
    }
    else if (s[0] == 'S')
    {
        //  write list
        //  vector<string> v={portalID,reqID,"Start"};
        //  reqRecord.push_back(v);
        reqRecord.push_back({to_string(portalID), to_string(reqID), "Start"});
        MyFile << portalID << " " << this->reqID++ << " Start" << endl;
    }
}

void DemoPortal::checkResponse()
{
    ifstream inpFile1("PlatformToPortal.txt");
    int num = 0;
    string str;
    while (getline(inpFile1, str))
    {
        num++;
    }
    inpFile1.close();
    ifstream inpFile("PlatformToPortal.txt");
    string line;
    vector<string> readLine; // Store splt line
    string prevreqID = "";
    string type = "";
    string sortOrder = "";

    vector<vector<string>> input;
    while (getline(inpFile, line))
    {
        num--;
        splitting(line, readLine); // SPlitting line
        if (prevreqID != readLine[1] && prevreqID != "")
        {
            for (auto e : reqRecord)
            {
                if (e[1] == prevreqID)
                {
                    type = e[2];
                    // cout<<type<<"---Type"<<endl;
                    if (type == "List")
                    {
                        // cout<<"kjhfjhj"<<endl;
                        sortOrder = e[4];
                        // cout<<sortOrder<<"Sort Order"<<endl;
                    }
                    break;
                }
            }
            if (type == "Start")
            {
                cout<<portalID<<" "<<reqID<<" ";
                for (int e = 2; e < readLine.size(); e++)
                {
                    cout << input[0][e] <<" ";
                }
                cout<<endl;
                reqRecord.erase(reqRecord.begin());
            }
            else if (type == "List") // Sorting and Shpwing output in Terminal Accordingly
            {
                // cout<<sortOrder<<"  hjhk"<<endl;
                if (sortOrder == "Price")
                {
                    Comparator cmp(4);
                    // cout<<"Here";
                    sort(input.begin(), input.end(), cmp);
                }
                else if (sortOrder == "Name")
                {
                    Comparator cmp(3);
                    sort(input.begin(), input.end(), cmp);
                }
                else if (sortOrder == "Quantity")
                {
                    Comparator cmp(5);
                    sort(input.begin(), input.end(), cmp);
                }
                else if (sortOrder == "ID")
                {
                    Comparator cmp(2);
                    sort(input.begin(), input.end(), cmp);
                }
                for (auto e : input)
                {
                    // cout<<e.size();
                    cout << e[0] << " " << e[1] << " " << e[2] << " " << e[3] << " " << e[4] << " " << e[5] << endl;
                }
                cout << endl;
                reqRecord.erase(reqRecord.begin());
                type = "";
            }
            else if (type == "Buy")
            {
                cout << input[0][0] << " " << input[0][1] << " " << input[0][2] << endl;
                cout << endl;
                reqRecord.erase(reqRecord.begin());
            }

            prevreqID = readLine[1];
            input.clear();
            input.push_back(readLine);
            type = "";
        }
        else
        {
            if (prevreqID == "")
            {
                prevreqID = readLine[1];
            }
            input.push_back(readLine);
        }
        if (num == 0)
        {
            // cout<<"hjbjhvd"<<endl;
            prevreqID = readLine[1];
            for (auto e : reqRecord)
            {
                if (e[1] == prevreqID)
                {
                    type = e[2];
                    // cout<<type<<endl;
                    if (type == "List")
                    {
                        // cout<<e[4]<<"......";
                        sortOrder = e[4];
                        // cout<<sortOrder<<endl;
                    }
                    break;
                }
            }
            if (type == "Start")
            {
                cout<<portalID<<" "<<reqID<<" ";

                for (int e = 2; e < readLine.size(); e++)
                {
                    cout << input[0][e] <<" ";
                }
                cout<<endl;
                reqRecord.erase(reqRecord.begin());
            }
            else if (type == "List")
            {
                // cout<<"Here 1"<<endl;
                // cout<<sortOrder<<endl;
                if (sortOrder == "Price")
                {
                    Comparator cmp(4);
                    sort(input.begin(), input.end(), cmp);
                }
                else if (sortOrder == "Name")
                {
                    Comparator cmp(3);
                    sort(input.begin(), input.end(), cmp);
                }
                else if (sortOrder == "Quantity")
                {
                    Comparator cmp(5);
                    sort(input.begin(), input.end(), cmp);
                }
                else if (sortOrder == "ID")
                {
                    Comparator cmp(2);
                    sort(input.begin(), input.end(), cmp);
                }
                for (auto e : input)
                {
                    cout << e[0] << " " << e[1] << " " << e[2] << " " << e[3] << " " << e[4] << " " << e[5] << endl;
                }
                cout << endl;
                reqRecord.erase(reqRecord.begin());
                type = "";
            }
            else if (type == "Buy")
            {
                cout << input[0][0] << " " << input[0][1] << " " << input[0][2] << endl;
                reqRecord.erase(reqRecord.begin());
            }
            prevreqID = readLine[1];
            input.clear();
            input.push_back(readLine);
            type = "";
        }
        readLine.clear();
    }
}
