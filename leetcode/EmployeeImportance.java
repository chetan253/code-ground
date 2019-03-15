class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> empMap = new HashMap<Integer, Employee>();
        
        for(Employee emp : employees){
            empMap.put(emp.id, emp);
        }
        
        return getImportance(id, empMap);
    }
    
    public int getImportance(int empId, HashMap<Integer, Employee> empMap){
        Employee emp = empMap.get(empId);
        if(emp == null){
            return 0;
        }
        if(emp.subordinates.size() == 0 || emp.subordinates == null){
            return emp.importance;
        }
        int result = 0;
        for(Integer eid : emp.subordinates){
            result = result + getImportance(eid, empMap);
        }
        return result + emp.importance;
    }
}
