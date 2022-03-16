package com;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainApp  {
    public static void main(String[] args) {
        try {

            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            String bn=br.readLine();
            Float bm=Float.parseFloat(br.readLine());
            Student obj_s = new Student();
            obj_s.setName(bn);
            obj_s.setMarks(bm);

            Configuration config = new Configuration();
//            config.addAnnotatedClass(Student.class);
            config.configure("hibernate.cfg.xml");
            SessionFactory sf = config.buildSessionFactory();
            Session s2 = sf.openSession();
            Transaction transact = s2.beginTransaction();
            int i=(int)s2.save(obj_s);
            if(i>0) {
                transact.commit();
                System.out.println("Success");
            }
            else{
                System.out.println("Try");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
