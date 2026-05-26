public class Librarian extends Person {
    private String employeeCode;

    public Librarian(int id, String name, String employeeCode) {
        super(id, name);
        this.employeeCode = employeeCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    @Override
    public void displayDetails() {
        System.out.println("Librarian ID   : " + getId());
        System.out.println("Name           : " + getName());
        System.out.println("Employee Code  : " + employeeCode);
        System.out.println("---------------------------");
    }
}
