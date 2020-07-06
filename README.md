"# StudyProjects" 
vector<int> v = {1,2,3,4,5};

 v.erase(remove_if(v.begin(), v.end(), [](int x) {return x < 1 || x > 4;}), v.end());