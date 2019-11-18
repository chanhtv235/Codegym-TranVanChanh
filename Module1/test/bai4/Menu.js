
let infoEmployee = [];
function mainMenu() {
    let select = prompt("" +
        "1.Login.\n" +
        "2.Register.\n" +
        "3.Exit.\n" );
    switch (select) {
        case "1":
            Login(infoEmployee);
            mainMenu();
            break;
        case "2":
            addNewEmployee()
            mainMenu();
            break;
        case "3":
            break;

        default:
            mainMenu();
    }
}
/////////////////////////////////////////////////////////////////////////
function addNewEmployee() {
    let employee = new Employee();
    employee.setName(prompt("1.Enter new name employee"));
    employee.setUser(prompt("1.Enter new User employee"));
    employee.setPassword(prompt("1.Enter new Password employee"));
    employee.setBirthDay(prompt("1.Enter new Birthday employee"));
    employee.setIDCard(prompt("1.Enter new IDCard employee"));
    employee.setGender(prompt("1.Enter new Gender employee"));
    employee.setAddress(prompt("1.Enter new Address employee"));
    employee.setPhoneNumber(prompt("1.Enter new Phone employee"));

    do {
        checkStatus=true;
        employee.setEmail(prompt("1.Enter new Email employee"));
        let patt=/[\w]+@[a-z]+\.[a-z]+/;
        if (patt.test(employee.getEmail())) {
            checkStatus=false
        }
    }while(checkStatus);

    ////////////////////////////////////////////////////////////////////

    infoEmployee[0] = employee.getName();
    infoEmployee[1] = employee.getUser();
    infoEmployee[2] = employee.getPassWord();
    infoEmployee[3] = employee.getBirthDay();
    infoEmployee[4] = employee.getIDCard();
    infoEmployee[5] = employee.getGender();
    infoEmployee[5] = employee.getAddress();
    infoEmployee[5] = employee.getPhoneNumber();
    infoEmployee[5] = employee.getEmail();
}
///////////////////////////////////////////////////////////////
function Login(infoEmployee) {
   let Account=prompt("1.Enter Account \n");
    let password =prompt("2.Enter password");
    let check=false;
    do {
        let check=false;
        if (Account==infoEmployee[1]&&password==infoEmployee[2]) {
            alert("Bạn đã đăng nhập thành công");
            check=false;
        }else {
            alert("Bạn đăng nhập sai tên hoặc mật khẩu.\n Đăng nhập lại");
            check=true;
        }
    }while (check)

}

