package com.wwwxy.employeemanagement.control;

import java.util.List;
import java.util.Scanner;

import com.wwwxy.employeemanagement.dao.LoginDao;
import com.wwwxy.employeemanagement.entity.LoginEntity;

public class LoginControl {
	public int login(){
		int id = 0;
		Scanner input =new Scanner(System.in);
		int count =0;
		String username;
		String password;
		do{
			System.out.println("�������˺ţ�");
			username = input.next();
			System.out.println("���������룺");
			password = input.next();
			LoginDao ld = new LoginDao();
			id = ld.login(username, password);
			if(id !=0){
				String username1 = ld.getLoginById5(id);
				System.out.println("��ϲ�㣬��¼�ɹ�"+"\t"+username1);
				break;
			}else{
				count++;
				System.out.println("��¼ʧ�ܣ�������"+(3-count)+"�λ��ᡣ");
			}
		}while(count<3);
		if(count==3){
			return 0;
		}
		return id;
	}
	LoginDao ld = new LoginDao();
	//��ʾ���е�¼��Ϣ
	public List<LoginEntity> getAllLogin(){
		return ld.getAllLogin();
	}
	//�����˺Ų�ѯ��Ϣ,ģ����ѯ
	public List<LoginEntity> getLoginByUsername(String username){
		return ld.getLoginByUsername(username);
	}
	//��������
	public int updateLoginById1(int id){
		return ld.updateLoginById1(id);
	}
	//����ID�޸��˺�
	public int updateLoginById2(int id,String username){
		return ld.updateLoginById2(id, username);
	}
	//���ݱ�Ų�����Ϣ
	public LoginEntity getLoginById4(int id){
		return ld.getLoginById4(id);
	}
//	//����id�����˺�
//	public string getLoginById5(int id){
//		return ld.getLoginById5(username)
//	}
	//������Ϣ
	public int addLogin(LoginEntity le){
		return ld.addLogin(le);
	}
	//ɾ����Ϣ
	public int delLoginByEmpid3(int id){
		return ld.delLoginById3(id);
	}
	//����id������
	public String getLoginById(int empid,String oldpassword){
		return ld.getLoginById(empid,oldpassword);
	}
	//������
	public int UpdateLoginPassword(String password,int id){
		return ld.UpdateLoginPassword(password,id);
	}
}
