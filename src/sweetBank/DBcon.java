/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





// THIS IS THE NEWEST ONE, CHECK ONE, CHECK TWO, DANSA PAUSA






package sweetBank;

import java.security.MessageDigest;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vladde
 */
public class DBcon {

    private Connection con;
    private static Statement[] st = new Statement[50];
    private ResultSet res;
    private UserAccount user = new UserAccount();
    private Frmlogin logg = new Frmlogin(this);
    private Random ran = new Random(12);

    public DBcon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sweetbankDB", "root", "root");
            for (int x = 0; x < st.length; x++) {
                st[x] = con.createStatement();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void addPerson(String[] info) {
        try {

            int id = 0;
            boolean acctOK = false;
            String tempAcct = "nothing";
            String personN = "not";
            String fName = info[0];
            String lName = info[1];
            String pNumber = info[2];
            String pNumber2 = info[8];
            String address = info[3];
            String email = info[4];
            String phone = info[5];
            String title = info[6];
            String passW = info[7];

            String creds = String.format("insert into credentials(password,email)"
                    + " values('%s','%s')", passW, email);
            st[0].executeUpdate(creds);

            String retrieveDB = "select * from credentials";
            res = st[1].executeQuery(retrieveDB);
            while (res.next()) {
                id = res.getInt("id");
                String strEm = res.getString("email");

                if (strEm.equals(email)) {
                    String total = String.format("insert into account_owner(name,person_number,credentials_id,address,phone_number,title)"
                            + " values('%s %s','%s %s',%s,'%s','%s','%s') ",
                            fName, lName, pNumber, pNumber2, id, address, phone, title);
                    st[2].executeUpdate(total);
                    String sss = "select person_number from account_owner where credentials_id ='" + id + "';";
                    res = st[33].executeQuery(sss);
                    while (res.next()) {
                        personN = res.getString("person_number");
                    }
                }
            }

            String accountInput = "fail";
            String accountCheck = String.format("%d", generateAccountNumber());
            retrieveDB = String.format("select * from account where account_number = '" + accountCheck + "';");
            res = st[3].executeQuery(retrieveDB);
            if (res.next()) {
                tempAcct = res.getString("account_number");
                if (tempAcct.equals(accountCheck)) {
                    accountCheck = String.format("%d", generateAccountNumber());
                }
            } else {
                accountInput = accountCheck;
            }

            String addAccountInfo = String.format("insert into account(balance,account_number,account_owner_person_number)"
                    + " values('%s','%s','%s')", generateBalance(), accountInput, personN);

            st[4].executeUpdate(addAccountInfo);

            String ddd = "select * from account where account_owner_person_number ='" + personN + "';";
            res = st[38].executeQuery(ddd);
            if (res.next()) {
                String dodo = "select balance, account_number from account where account_owner_person_number ='" + personN + "';";
                res = st[32].executeQuery(dodo);
                while (res.next()) {

                    float balan = res.getFloat("balance");
                    String accountNo = res.getString("account_number");

                    System.out.println(accountNo);

                    //String perNum = String.valueOf(pNumber);
                    /*String addHistory = "insert into account_history"
                            + "(account_number_history,account_balance,account_owner_person_number) "
                            + "values ('" + accountNo + "'," + balan + ",'" + personN + "')";
                    st[33].executeUpdate(addHistory); */

                    

                    String dooo = "select name from account_owner where person_number = '" + personN + "';";
                    res = st[34].executeQuery(dooo);
                    System.out.println(personN);
                    while (res.next()) {
                        String name = res.getString("name");
                        System.out.println(name);
                        /*String addName = "insert into account_history (account_name) values ('" + name + "');";
                        System.out.println(addName);
                        st[38].executeUpdate(addName);*/
                    }


                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //Vladimir
    public String generateBalance() {
        Random random = new Random();
        int returnValue = 500 + random.nextInt(100000);
        return String.format("%d", returnValue);

    }

    //Vladimir
    public int generateAccountNumber() {
        int[] acc = new int[6];
        String returnValue = "";
        for (int i = 0; i < acc.length; i++) {
            Random random = new Random();
            int accValue = random.nextInt(9) + 1;
            acc[i] = accValue;
            returnValue = returnValue + String.format("%d", acc[i]);
        }
        return Integer.parseInt(returnValue);

    }

    //David && Vladimir
    public void login(String email, String password, Frmlogin f) {
        try {
            if (email.length() != 0 && password.length() != 0) {
                String sql = "Select * from credentials where email= '" + email + "' and password='" + password + "'";
                res = st[5].executeQuery(sql);

                if (res.next()) {
                    String id = String.format("%d", res.getInt("id"));

                    String sqlGetPNumber = String.format("select * from account_owner where credentials_id =" + id + ";");
                    ResultSet res2 = st[17].executeQuery(sqlGetPNumber);
                    if (res2.next()) {
                        FrmUser users = new FrmUser(email, res2.getString("person_number"));
                        users.setVisible(true);
                        f.dispose();
                    }

                } else {
                    logg.loginPopUp();
                }
            } else {
                logg.loginPopUp();
                System.out.println("no user");
            }
        } catch (SQLException et) {
            logg.setErrorSign();
            System.out.println("errrrrrror");
        }
    }

    //David && Hassan
    public void takeOutLoan(float loanAmount, float monthlyRepayments, String i) {
        int flor = 0;
        try {

            String spl = "select loan_amount from account where account_owner_person_number =" + i + ";";
            res = st[14].executeQuery(spl);

            if (res.next()) {

                flor = res.getInt("loan_amount");
                if (flor != 0) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "There is already one loan attached to this account, "
                            + "you will now automatically be re-directed to the main menu", "Max one loan per account", 2);

                } else {
                    String swl = "update account set loan_amount=" + loanAmount + ", loan_repayment=" + monthlyRepayments + " where account_owner_person_number=" + i + ";";
                    st[6].executeUpdate(swl);
                    String sql = "select balance, loan_amount from account where account_owner_person_number=" + i + ";";
                    res = st[7].executeQuery(sql);
                    if (res.next()) {
                        float bal = res.getFloat("balance");
                        float loan = res.getFloat("loan_amount");
                        float total = bal + loan;

                        String setBalance = "update account set balance =" + total + " where account_owner_person_number=" + i + ";";
                        st[8].executeUpdate(setBalance);
                        JFrame framey = new JFrame();
                        JOptionPane.showMessageDialog(framey, "Loan approved, the money is now in your account", "Loan approved", 1);

                    }

                }
            } else {
                System.out.println("problem");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    //week 2
    //Hassan

    public String getId(String email) {
        String returnValue = "no";
        try {
            String sql = "select id from credentials where email = '" + email + "';";
            res = st[9].executeQuery(sql);
            if (res.next()) {
                returnValue = String.valueOf(res.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnValue;
    }

    //David && Hassan
    public boolean checkPass(String pas, int passAttempt) {
        boolean OK = false;
        while (!OK) {
            String returnValue = "";
            try {
                String sql = "select password from credentials where password ='" + pas + "';";

                res = st[10].executeQuery(sql);

                if (res.next()) {

                    returnValue = res.getString("password");
                    OK = true;

                } else {

                    if (passAttempt < 3) {
                        OK = false;
                        JFrame fram = new JFrame();
                        JOptionPane.showMessageDialog(fram, "Incorrect password used"
                                + "\n  MAX 3 ATTEMPTS" + "\n Attempt " + passAttempt + "", "Incorrect password", 2);
                        break;
                    } else {
                        OK = false;
                        JFrame framee = new JFrame();
                        JOptionPane.showMessageDialog(framee, "You have entered the incorrect password 3 times, for "
                                + "security reasons you will now be automatically re-directed to the"
                                + "main menu", "Max amount of incorrect passwords reached", 2);
                        Frmlogin frm = new Frmlogin(this);
                        frm.setVisible(true);
                        break;
                    }

                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return OK;
    }

    //Hassan
    public String getBalance(String a) {
        String returnValue = "HassanIsBack";
        try {
            String getBal = "select balance from account where account_owner_person_number = '" + a + "';";

            res = st[12].executeQuery(getBal);
            if (res.next()) {
                returnValue = String.format("%.2f", res.getFloat("balance"));

            }
            return returnValue;

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

//------------This method will retrieve user's account number from account table in the db---------------//
    //Hassan
    public String getAccountNumber(String a) {
        String returnValue = "nothing";
        try {
            String getAcNo = "select account_number from account where account_owner_person_number = '" + a + "';";
            res = st[13].executeQuery(getAcNo);
            if (res.next()) {
                returnValue = res.getString("account_number");

            }

        } catch (Exception ex) {
            return ex.getMessage();

        }
        return returnValue;
    }

//------------This method will retrieve user's name from account_owner table in the db---------------//
    //Hassan
    public String getName(String a) {
        String returnValue = "nothing";
        try {
            String getName = "select name from account_owner where person_number = '" + a + "';";
            res = st[14].executeQuery(getName);
            if (res.next()) {
                returnValue = res.getString("name");
            }

        } catch (Exception ex) {
            return ex.getMessage();

        }
        return returnValue;
    }

//------------This method will retrieve address from account_owner table in the db---------------//
    //Hassan
    public String getAddress(String a) {
        String returnValue = "nothing";
        try {
            String getAddress = "select address from account_owner where person_number = '" + a + "';";
            res = st[15].executeQuery(getAddress);
            if (res.next()) {
                returnValue = res.getString("address");
            }

        } catch (Exception ex) {
            return ex.getMessage();

        }
        return returnValue;
    }

    //------------This method will retrieve email address from credentials table in the db---------------//
    //Hassan
    public String getEmail(String a) {
        String returnValue = "nothing";
        try {
            String getEmail = "select credentials.email from credentials, account_owner where account_owner.person_number ='" + a
                    + "' and account_owner.credentials_id = credentials.id ;";
            res = st[16].executeQuery(getEmail);
            if (res.next()) {
                returnValue = res.getString("email");
            }

        } catch (Exception ex) {
            return ex.getMessage();

        }
        return returnValue;
    }

    //------------This method will retrieve phone number from account_owner table in the db---------------//
    //Hassan
    public String getPhone(String a) {
        String returnValue = "nothing";
        try {
            String getPhone = "select phone_number from account_owner where person_number= '" + a + "';";
            res = st[19].executeQuery(getPhone);

            if (res.next()) {
                returnValue = res.getString("phone_number");
            }

        } catch (Exception ex) {

            return ex.getMessage();

        }

        return returnValue;
    }

    //David && Hassan
    public boolean transfer(int acc, int personN) {
        boolean OK = false;
        while (!OK) {
            try {
                int returnValue = 0;
                int returnValue1 = 0;
                String sql = "select * from account where account_number = '" + acc + "';";
                res = st[21].executeQuery(sql);

                if (res.next()) {
                    returnValue = res.getInt("account_owner_person_number");

                    String state = "select * from account_owner where person_number = '" + returnValue + "';";
                    res = st[22].executeQuery(state);

                    if (res.next()) {
                        returnValue1 = res.getInt("person_number");

                        if (returnValue1 == personN) {

                            OK = true;
                            break;

                        } else {
                            OK = false;

                        }
                    } else {
                        OK = false;
                    }
                } else {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "The account number and person number "
                            + "do not match, please try again", "Wrong input", 2);
                    break;
                }
            } catch (Exception ee) {
                ee.getMessage();
            }
        }
        return OK;
    }

    //David && Hassan
    public void transferMoney(float amount, int acc, String personNum) {
      
        try {
            float senderBalance = 0;
            float senderBalance2 = 0;
            float recieverBalance = 0;
            String spl = "select balance from account where account_number = '" + acc + "';";
            res = st[24].executeQuery(spl);
            while (res.next()) {
                recieverBalance = res.getFloat("balance");
                String str = "select balance from account where account_owner_person_number = " + personNum + ";";
                res = st[26].executeQuery(str);
                while (res.next()) {
                    senderBalance2 = res.getFloat("balance");
                    if (senderBalance2 >= amount) {
                        recieverBalance = recieverBalance + amount;
                        String sql = "update account set balance = '" + recieverBalance + "' where account_number = " + acc + ";";
                        st[25].executeUpdate(sql);
                        senderBalance = senderBalance2 - amount;
                        String stt = "update account set balance = '" + senderBalance + "' "
                                + "where account_owner_person_number = " + personNum + ";";
                        st[27].executeUpdate(stt);
                        st[27].close();
                        res.close();
                        
                    } else {
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "You have insufficient funds, the max you can transfer is '" + senderBalance2 + "'", "Insufficient funds", 2);
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBcon.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //David
    public void depositMoney(float amount, String personNumb) {
        float newBalance = 0;
        float oldBalance = 0;
        try {
            String sppl = "select balance from account where account_owner_person_number = " + personNumb + "";
            res = st[28].executeQuery(sppl);
            while (res.next()) {
                oldBalance = res.getFloat("balance");
                newBalance = oldBalance + amount;
                String strr = "update account set balance = '" + newBalance + "' where account_owner_person_number=" + personNumb + "";
                st[29].executeUpdate(strr);

                Calendar currentDate = Calendar.getInstance();
                SimpleDateFormat formatter =
                        new SimpleDateFormat("dd/MMM/yyyy");
                String dateNow = formatter.format(currentDate.getTime());
                //String sel = "insert into account_history (account_date, account_number, account_balance, ) values ('" + dateNow + "') "
                  //      + "where account_owner_person_number=" + personNumb + ";";

              //  st[31].executeUpdate(sel);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

    }

    //David
    public void withdrawMoney(float amount, String personNumbe) {
        float newBalance = 0;
        float oldBalance = 0;
        try {
            String sppl = "select balance from account where account_owner_person_number = " + personNumbe + "";
            res = st[28].executeQuery(sppl);
            while (res.next()) {
                oldBalance = res.getFloat("balance");
                newBalance = oldBalance - amount;
                System.out.println(oldBalance);
                System.out.println(newBalance);
                String strr = "update account set balance = '" + newBalance + "' where account_owner_person_number = " + personNumbe + "";
                st[29].executeUpdate(strr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBcon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Vladimir
    public String md5(char[] c) {
        try {
            MessageDigest digestMD5 = MessageDigest.getInstance("MD5");
            digestMD5.update((new String(c)).getBytes("UTF8"));
            return new String(digestMD5.digest());
        } catch (Exception e) {
            return "";
        }
    }

    
    //Hassan
    public boolean checkTransferCompany(String comName, int comNumber) {
        boolean OK = false;
        while (!OK) {
            try {
                String company_name = "haha";
                String sql = "select * from company where company_number = '" + comNumber + "';";
                res = st[39].executeQuery(sql);

                if (res.next()) {
                    company_name = res.getString("company_name");

                    if (company_name.equals(comName)) {
                        System.out.println("got it");
                        OK = true;
                        break;

                    } else {

                        OK = false;
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "The company number and company name "
                                + "do not match, please try again", "Wrong input", 2);
                        break;

                    }

                } else {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "The company number and company name "
                            + "do not match, please try again", "Wrong input", 2);
                    break;

                }
            } catch (Exception ee) {
                ee.getMessage();
            }
        }
        return OK;
    }
    
    //Hassan
    public void transferToCompany(float amount, int companyNum, String personNum) {
        float comBalance = 0;
        float senderBalance = 0;
        float senderNewBalance = 0;

        try {
            String sql = "select balance from company where company_number = '" + companyNum + "';";
            res = st[35].executeQuery(sql);
            while (res.next()) {
                comBalance = res.getFloat("balance");
                String ssl = "select balance from account where account_owner_person_number = " + personNum + ";";
                res = st[36].executeQuery(ssl);
                while (res.next()) {
                    senderBalance = res.getFloat("balance");
                    if (senderBalance >= amount) {
                        comBalance = comBalance + amount;
                        String sp = "update company set balance = " + comBalance + "where company_number = " + companyNum + ";";
                        st[37].executeUpdate(sp);
                        senderNewBalance = senderBalance - amount;
                        String stl = "update account set balance = " + senderNewBalance + ""
                                + "where account_owner_person_number = " + personNum + " ;";
                        st[38].executeUpdate(stl);

                    } else {
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "You have insufficient funds, the max you can pay is '" + senderBalance + "'", "Insufficient funds", 2);
                    }

                }
            }
        } catch (Exception ex) {
            ex.getMessage();
        }

    }
}
