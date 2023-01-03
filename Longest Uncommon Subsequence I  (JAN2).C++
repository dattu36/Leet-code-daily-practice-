class Solution {
public:
    int compare(string a, string b) {
        string ans;
        for(int i=0; i<a.size(); i++) {
            for(int j=i; j<a.size(); j++) {
                string sub = a.substr(i, j-i+1);
                if(b.find(sub) == std::string::npos) {
                    ans = sub.length() > ans.length() ? sub : ans;
                }
            }
        }
        return ans.length();
    }
    int findLUSlength(string a, string b) {
        int ab = compare(a, b);
        int ba = compare(b, a);
        int ans = max(ab, ba);
        return ans > 0 ? ans : -1;
    }
};