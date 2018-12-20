package com.wwwxy.employeemanagement.control;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;





import com.wwwxy.employeemanagement.dao.SalaryDao;
import com.wwwxy.employeemanagement.dao.SalarySumDao;
import com.wwwxy.employeemanagement.entity.SalaryEntity;

public class SalaryControl {
	SalaryDao sd =new SalaryDao();
	Scanner sc = new Scanner(System.in);
	
	//��ѯ����
	public void GetAllSalary() {
		List<SalaryEntity> list = sd.GetAllSalary();
		System.out.println("���ʱ��\tԱ��ID\t����ID\t�����ܺ�\t������ʱ��\t");
		for(SalaryEntity list1:list){
			System.out.println(list1.getsId()+"\t"+list1.getEmpId()+"\t"
		+list1.geteId()+"\t"+list1.getsSum()+"\t"+list1.getsTime());
		}
	}
	//��ѯĳ��Ա����Ϣ��ʹ��Ա��ID��ѯ
	public void GetSalaryById(int id) {
		List<SalaryEntity> list = sd.GetSalaryById(id);
		System.out.println("���ʱ��\tԱ��ID\t����ID\t�����ܺ�\t������ʱ��\t");
		for(SalaryEntity list1:list){
			System.out.println(list1.getsId()+"\t"+list1.getEmpId()+"\t"
		+list1.geteId()+"\t"+list1.getsSum()+"\t"+list1.getsTime());
		}
	}
	
	//����Ա��
	public void AddSalary() {
		System.out.println("���������ӵ�Ա�����:");
		int empid = sc.nextInt();
		int eid=new SalarySumDao().GetEventIdByEmpId(empid);
		System.out.println("���������ӵķ�����ʱ��:");
		String stime = sc.next();
		SalaryEntity se = new SalaryEntity(0, empid, eid, 0, stime);
		int row = sd.add(se);
		if(row>0){
			System.out.println("�����ɹ�");
			GetAllSalary();
		}else{
			System.out.println("����ʧ��");
		}
	}
	
	//ɾ��
	public void DeleteSalary() {
		System.out.println("��������Ҫɾ���Ĺ���ID:");
		int id = sc.nextInt();
		int row = sd.delete(id);
		if(row>0){
			System.out.println("�����ɹ�");
			GetAllSalary();
		}else{
			System.out.println("����ʧ��");
		}
	}
//	�޸���Ϣ
	public void UpdateSalary() {
		SalaryEntity se = new SalaryEntity();
		GetAllSalary();
		System.out.println("��������Ҫ�޸ĵĹ��ʱ��:");
		int id = sc.nextInt();
		se.setsId(id);
		List<SalaryEntity> list = sd.GetSalaryById(id);
		for(SalaryEntity list1:list){
			se.setEmpId(list1.getEmpId());
			se.seteId(list1.geteId());
			se.setsSum(list1.getsSum());
			se.setsTime(list1.getsTime());
		}
		System.out.println("��������Ҫ�޸ĵ�����(��ʽ:2000-01-01):");
		String stimeString = sc.next();
		se.setsTime(stimeString);
		
		int row = sd.update(se);
		if(row>0){
			System.out.println("�����ɹ�");
			GetAllSalary();
		}else{
			System.out.println("����ʧ��");
		}
	}
	//���¹��ʼ�¼
	public void UpdateSalaryByEmpId() {
		
		new SalaryDao().GetAllSalary();
		GetAllSalary();
		int empid=0 ;
		System.out.println("��������Ҫ���µ�Ա��ID��");
		boolean flag = true;
		int row =0;
		while(flag){
			try {
				empid = sc.nextInt();
				flag = false;
				float salary = new SalarySumDao().SalarySum(empid);
				row = sd.UpdateSalaryByEmpId(empid, salary);
			} catch (InputMismatchException e) {
				System.out.println("��������,����������");
				sc = new Scanner(System.in);
				flag = true;
				continue;
			}catch (NullPointerException e) {
				System.out.println("�����ڸ�Ա��������������");
				sc = new Scanner(System.in);
				flag = true;
				continue;
				}
		}
		if(row>0){
			System.out.println("�����ɹ�");
			GetAllSalary();
		}else{
			System.out.println("����ʧ��");
		}
	}
	
	
	public void Salary() {
		String chose = "y";
		while("y".equals(chose)){
			System.out.println("��ѡ����Ҫ���еĲ���:");
			System.out.println("1���������ʼ�¼");
			System.out.println("2��ɾ�����ʼ�¼");
			System.out.println("3����ѯ���ʼ�¼");
			System.out.println("4���޸ķ�����ʱ��");
			System.out.println("5�����¹��ʼ�¼");
			int num =0;
			try {
				num=sc.nextInt();
			} catch (Exception e) {
				System.out.println("��������,����������");
				sc = new Scanner(System.in);
				continue;
			}
			
			switch (num) {
			case 1:
				AddSalary();
				break;
			case 2:
				DeleteSalary();
				break;
			case 3:
				GetAllSalary();
				break;
			case 4:
				UpdateSalary();
				break;
			case 5:
				UpdateSalaryByEmpId();
				break;
			default:
				System.out.println("��������");
				break;
			}
			System.out.println("�Ƿ������������������y/n��");
			chose = sc.next();
			while(!"n".equals(chose)&&!"y".equals(chose)){
				System.out.println("��������������y����n");
				chose = sc.next();
			}
		}
		if("n".equals(chose)){
			System.out.println("���˳����ʼ�¼����");
		}
	}
	
}
