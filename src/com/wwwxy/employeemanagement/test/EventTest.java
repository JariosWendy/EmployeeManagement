package com.wwwxy.employeemanagement.test;
import java.util.List;
import java.util.Scanner;

import com.wwwxy.employeemanagement.dao.EventDao;
import com.wwwxy.employeemanagement.entity.CheckDetails;
import com.wwwxy.employeemanagement.entity.EventEntity;


//import com.wwwxy.employeemanagement.entity.EventEntity;

public class EventTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventDao eve = new EventDao();
		/*List<EventEntity> list = eve.getAllEvent();
		System.out.println("��������\t\tԱ�����\t\t�ٵ�����\t\t�Ӱ����\t\t�������");
		for(EventEntity e:list){
			System.out.println(e.geteId()+"\t\t"+e.geteMpid()+"\t\t"+e.geteClocking()+"\t\t"+e.geteBigevent()+"\t\t"+e.geteAward());
		}*/
		
		
		
			EventEntity ee = new EventEntity();
			/*int a=103;
			int b=4;
			int c=4;
			int d=4;
			int e=4;
			ee.seteClocking(b);
			ee.seteOvertime(c);
			ee.seteBigevent(d);
			ee.seteAward(e);
			ee.geteId();
			int row = eve.addEventEntity(ee);
			System.out.print(row);*/
		
		
		/*t.seteMpid(102);
		t.seteClocking(1);
		t.seteOvertime(1);
		t.seteBigevent("����");
		t.seteAward(2);
		t.seteId(1);
		int row = eve.updateEventEntityById(t);
		System.out.print(row);*/
		/*EventEntity t1 = new EventEntity();
		t1.seteId(16);*/
		
		
		/*int row1 = eve.DropEventEntity(16);
		System.out.print(row1);*/
		
		/*List<EventEntity> list1 = eve.getAllEventEntity(103);
		System.out.println("��������\t\tԱ�����\t\t�ٵ�����\t\t�Ӱ����\t\t�������");
		for(EventEntity t1:list1){
			System.out.println(t1.geteId()+"\t\t"+t1.geteMpid()+"\t\t"+t1.geteClocking()+"\t\t"+t1.geteBigevent()+"\t\t"+t1.geteAward());
		}*/
			System.out.println("���Ժ�---");
		List<CheckDetails> list2 = eve.updateEventCheckdetails();
		String a = null;
		boolean flag = false;
		int c ;
		for(CheckDetails b:list2){
			int Clocking = 0;
			int Overtime = 0;
			int Bigevent = 0;
			int Award = 0;
			 a=b.getCstatus();
			 c=b.getEmpid();
			 for(CheckDetails f:list2){
					if(a !=null){
						//����Ա��id�޸�������Ϣ
						List<EventEntity> list = eve.getEventById(c);
						for(EventEntity list1:list){
							//ee.seteMpid(list1.geteMpid());
							ee.seteClocking(list1.geteClocking());
							ee.seteOvertime(list1.geteOvertime());
							ee.seteBigevent(list1.geteBigevent());
							ee.seteAward(list1.geteAward());
						}
						//����Ա��id��ȡԱ�������������
						List<EventEntity> list1 = eve.getAllEventEntity(c);
						for(EventEntity e:list1){
						Clocking = e.geteClocking();//�ٵ�����
						Bigevent = e.geteBigevent();//����
						Overtime = e.geteOvertime();//�Ӱ�
						if(("����".equals(a))||("�ٵ�".equals(a)))
						{	 
							System.out.println("����Ա��id"+c);
							Clocking++;
							//System.out.println(Clocking);
							ee.seteClocking(Clocking);
							break;
						}
						if("����".equals(a)){
							System.out.println("����Ա��id"+c);
							Bigevent++;
							//System.out.println(Bigevent);
							ee.seteBigevent(Bigevent);
							break;
						}
						if("�Ӱ�".equals(a)){
							System.out.println("����Ա��id"+c);
							Overtime++;
							//System.out.println(Overtime);
							ee.seteOvertime(Overtime);
							break;
						}
						if("�ٵ�,�Ӱ�".equals(a)){
							System.out.println("����Ա��id"+c);
							Clocking++;
							ee.seteClocking(Clocking);
							Overtime++;
							ee.seteOvertime(Overtime);
							break;	
						}
						}
							}
					}
			 Award = (Clocking*-50+Overtime*50+Bigevent*-100);
			 ee.seteAward(Award);
			 int row = eve.updateEventEntityById(ee);
					}
		List<EventEntity> list = eve.getAllEvent();
			System.out.println("��������\t\tԱ�����\t\t�ٵ�����\t\t����\t\t�Ӱ����\t\t�������");
			for(EventEntity e:list){
				System.out.println(e.geteId()+"\t\t"+e.geteMpid()+"\t\t"+e.geteClocking()+"\t\t"+e.geteBigevent()+"\t\t"+e.geteOvertime()+"\t\t"+e.geteAward());
			}
		}	
	}
