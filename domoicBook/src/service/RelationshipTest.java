package service;


import javax.persistence.EntityManager;
import static utils.EntityManagerProvider.getEntityManager;

import model.Answer;
import model.Discussion;
import model.Flat;


//SANDBOX CLASS for tests

public class RelationshipTest {

	public static void main(String[] args) {
		
		 EntityManager entitymanager = getEntityManager();
		 
	      entitymanager.getTransaction( ).begin( );
	     /* 
	      Query query = entitymanager.createQuery( "SELECT e " + "FROM Obligation e",Obligation.class);
	       List<Obligation> list=(List<Obligation>)query.getResultList( );
	       for( Obligation e:list) {
	           System.out.print("\n\n\n"+"Obligation deadline: "+e.getDeadline()+"\n\n\n");
	        }
	        */
	      /*
	      Flat fl = new Flat( ); 
	       fl.setNumber(45);
	       fl.setRoomCount(4);
	       fl.setFlatSurface(55);
	       fl.setPassword("xmpl");
	      entitymanager.persist( fl );
	      
	      Flat fll = new Flat( ); 
	       fll.setNumber(46);
	       fll.setRoomCount(4);
	       fll.setFlatSurface(55);
	       fll.setPassword("xmplllll");
	      entitymanager.persist( fll);
	   
	      Flat flll = new Flat( ); 
	       flll.setNumber(47);
	       flll.setRoomCount(4);
	       flll.setFlatSurface(55);
	       flll.setPassword("xmpladas");
	      entitymanager.persist( flll );
	      
	 Obligation obl = new Obligation();
	       obl.setDebt(223.33);
	       obl.setDescription("Taksa");
	       obl.setDeadline("2015-08-01 04:09");
	       entitymanager.persist( obl );
	            
	       Query query = entitymanager.createQuery( "SELECT e " + "FROM Flat e");
	       List<Flat>list=query.getResultList();
	       for(Flat a:list){
	        Payment pay= new Payment();
	        pay.setFlat(a);
	        pay.setObligation(obl);
	        entitymanager.persist(pay);
	       }  
	 */
	     //  PaymentPK p=new PaymentPK();
	      // p.setFlatNumber(45);
	     //  p.setObligationId(4);
	       
	    //   Payment pay=entitymanager.find(Payment.class,p);
	    //   pay.setPaymentDate();
	     //  pay.setPaymentStatus(paymentStatus.PAID);
	       
	       Flat fl = new Flat( ); 
	       fl.setNumber(45);
	       fl.setRoomCount(4);
	       fl.setFlatSurface(55);
	       fl.setPassword("xmpl");
	       
	      entitymanager.persist( fl );
	      
		     Discussion ds = new Discussion();
		      ds.setContent("Test topic");
		      ds.setTitle("TITLE");
		      ds.setDate();
		     
		      
		    entitymanager.persist( ds );
		      
		      
		      
		      Answer aa = new Answer();
		      aa.setDate();
		      aa.setContent("I`m answering");
		      aa.setDiscussion(ds);
		      aa.setFlat(fl);
		      
		      
		    entitymanager.persist(aa);
	       
/*
	    //  Flat fl = new Flat( ); 
	   //   fl.setNumber(45);
	     // fl.setRoomCount(4);
	    //  fl.setFlatSurface(55);
	   //   fl.setPassword("xmpl");
	   //   fl.setPayments(new LinkedList<Payment>());
	     
	     //entitymanager.persist( fl );
	      
	      Flat fl2 = new Flat( ); 
	      fl2.setNumber(42);
	      fl2.setRoomCount(2);
	      fl2.setFlatSurface(95);
	      fl2.setPassword("xmpl2");
	     
	    //  entitymanager.persist( fl2 );
	      
	      PrivateMessage pm = new PrivateMessage();
	      pm.setTitle("FirstPM");
	      pm.setDate();
	      pm.setContent("SMSfail");
	      pm.setFlat1(fl);
	      pm.setFlat2(fl2);
	      
	    //  entitymanager.persist( pm );
	      
	      People ppl = new People();
	      ppl.setFirstName("Fname");
	      ppl.setLastName("Lname");
	      ppl.setFlat(fl2);
	      ppl.setStatus(status.NORMAL);
	      
	    //  entitymanager.persist( ppl );
	      

	//    Obligation obl = new Obligation();
	   // obl.setDebt(223.33);
	   // obl.setDescription("Taksa");
	  //  obl.setDeadline("2015-01-05 04:09");
	 //   obl.setPayments(new LinkedList<Payment>());
	     
	      
	    //  entitymanager.persist( obl );
	      
	     
	      Payment pay= new Payment();
	     // pay.setFlat(fl);
	     // pay.setObligation(obl);
	      pay.setPaymentDate();
	      fl.addPayment(pay);
	      obl.addPayment(pay);

	      
	    // entitymanager.persist( pay );
	      
	      Notification note = new Notification();
	      note.setContent("Notify");
	      note.setFlat(fl);
	      note.setTitle("Warning");
	      note.setDate();
	      
	    //  entitymanager.persist( note );
	      
	     Discussion ds = new Discussion();
	      ds.setContent("Test topic");
	      ds.setTitle("TITLE");
	      ds.setDate();
	     
	      
	    entitymanager.persist( ds );
	      
	      
	      
	      Answer aa = new Answer();
	      aa.setDate();
	      aa.setContent("I`m answering");
	      aa.setDiscussion(ds);
	      aa.setFlat(fl);
	      
	      
	   // entitymanager.persist(aa);
	  
	     // entitymanager.persist(fl);
	     // entitymanager.persist(obl);
	    //     entitymanager.persist( pay );
	   */   
		    
	      entitymanager.getTransaction( ).commit( );

	      entitymanager.close( );
	}

}
