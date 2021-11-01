package abchospital_db;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Junit {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/* DATABASE Connection */

	@Test
	public void testDatabaseConnectionConnected() throws ClassNotFoundException, SQLException, InterruptedException {
		 db = new Database();
		if (db.isConnected()) {
			assertEquals(true, db.isConnected());
		} else {
			assertEquals(false, db.isConnected());
		}
		Thread.sleep(200);
	}

	/*   ----  Login CRUD  ----   */

	@Test
	public void testRegistration() throws ClassNotFoundException, SQLException, InterruptedException {
		assertEquals(true, new Login().add("test@gmail.com","test#pass12"));
		Thread.sleep(200);
	}


	@Test
	public void testLoginUpdate() throws ClassNotFoundException, SQLException, InterruptedException {
		assertEquals(true, new Login().update("test@gmail.com", "test#pass12","test@gmail.com"));
		Thread.sleep(200);
	}
	
	@Test
	public void testLogin() throws ClassNotFoundException, SQLException, InterruptedException {
		assertEquals(true, new Login().userValid("test@gmail.com", "test#pass12"));
		Thread.sleep(200);
	}
	
	@Test
	public void testLoginDelete() throws ClassNotFoundException, SQLException, InterruptedException {
		assertEquals(true, new Login().deletec("test@gmail.com"));
		Thread.sleep(200);
	}
	
	
	/* Appoinment CRUD */

	@Test
	public void testAppoinment() throws ClassNotFoundException, SQLException {
		assertEquals(true, new Appoinment().add("test doctor", "test specialization", "test Hospital", "test date",
				"test userid 1234"));
	}

	@Test
	public void testAppoinmentUpdate() throws ClassNotFoundException, SQLException {
		assertEquals(true, new Appoinment().update("test doctor update", "test specialization update",
				"test Hospital update", "test date update", "test userid 1234 update", "test userid 1234"));
	}

	@Test
	public void testAppoinmentView() throws ClassNotFoundException, SQLException {
		ArrayList<AppoinmentModel> naList = new ArrayList<AppoinmentModel>();
		assertEquals(naList, new Appoinment().read());
	}


	public void testAppoinmentDelete() throws ClassNotFoundException, SQLException {
		assertEquals(true, new Appoinment().deletec("test userid 1234"));
	}

	/* Contact CRUD*/

	@Test
	public void testContactAdd() throws ClassNotFoundException, SQLException {
		ContactModel co = new ContactModel();
		co.setId(0);
		co.setName("test name");
		co.setEmail("testtest@gmail.com");
		co.setCall("0768755787");
		co.setMessage("test message");
		assertEquals(true, new Contact().add(co));
	}

	public void testContactView() throws ClassNotFoundException, SQLException {
		ArrayList<ContactModel> ccmList = new ArrayList<ContactModel>();
		assertEquals(ccmList, new Contact().read());
	}
 
	/* JOb Registration CRUDE*/

	@Test
	public void testJobRegistrationAdd() throws ClassNotFoundException, SQLException {
		JobRegistrationModel jo = new JobRegistrationModel();
		jo.setId(0);
		jo.setFirst("test first name");
		jo.setLast("test last name");
		jo.setMobile("076875578");
		jo.setEmail("testjob@gmail.com");
		jo.setCity("test city");
		jo.setCollage("test collage");
		jo.setDigree("test digree");
		jo.setMcid("test medicalid");
		jo.setSpc("test specification");
		assertEquals(true, new JobRegistration().add(jo));
	}

	@Test
	public void testJobRegistrationView() throws ClassNotFoundException, SQLException {
		ArrayList<JobRegistrationModel> jrmListt = new ArrayList<JobRegistrationModel>();
		assertEquals(jrmListt, new JobRegistration().read());
	}

	/* Doctors  */
	@Test
	public void testDoctorsAdd() throws ClassNotFoundException, SQLException {
		DoctorModel obj = new DoctorModel();
		obj.setId("0");
		obj.setName("test name");
		obj.setPosition("test position");
		obj.setHospital("test hospital");
		obj.setSpc("test spc");
		obj.setCall("0768755787");
		assertEquals(true, new Doctor().add(obj));
	}

	@Test
	public void testDoctorsUpdate() throws ClassNotFoundException, SQLException {
		DoctorModel obj = new DoctorModel();
		obj.setId("0");
		obj.setName("test name");
		obj.setPosition("test position");
		obj.setHospital("test hospital");
		obj.setSpc("test spc");
		obj.setCall("0768755787");
		assertEquals(true, new Doctor().update(obj));
	}

	@Test
	public void testDoctorsView() throws ClassNotFoundException, SQLException {
		ArrayList<DoctorModel> dmList = new ArrayList<DoctorModel>();
		dmList = new Doctor().read();
		assertEquals(dmList, new Doctor().read());
	}

	@Test
	public void testDoctorsDelete() throws ClassNotFoundException, SQLException {
		assertEquals(true, new Doctor().delete("0"));
	}

	/* Centers CRUD */
	
	@Test
	public void testCentersAdd() throws ClassNotFoundException, SQLException {
		
		obj.setId("1");
		obj.setName("test name");
		obj.setLocation("test location");
		assertEquals(true, new Centers().add(obj));
	}

	@Test
	public void testCentersView() throws ClassNotFoundException, SQLException {
		ArrayList<CentersModel> cmList = new ArrayList<CentersModel>();
		assertEquals(cmList, new Centers().read());
	}

	@Test
	public void testCentersDelete() throws ClassNotFoundException, SQLException {
		assertEquals(true, new Centers().delete("1"));
	}

	/* Medical Package CRUD */
	@Test
	public void testMedicalPackagesAdd() throws ClassNotFoundException, SQLException {
		MedicalPackagesModel obj = new MedicalPackagesModel();
		obj.setId(23);
		obj.setCall("07776878");
		obj.setCategry("categpry");
		obj.setDescription("descriptin");
		obj.setLocation("location");
		obj.setName("name");
		obj.setPrice("1000");
		obj.setServicetime("service name");
		obj.setServicetime("2021 10 21");
		assertEquals(true, new MedicalPackages().add(obj));
	}

	@Test
	public void testMedicalPackagesUpdate() throws ClassNotFoundException, SQLException {
		MedicalPackagesModel obj = new MedicalPackagesModel();
		obj.setId(23);
		obj.setCall("07776878");
		obj.setCategry("categpry");
		obj.setDescription("descriptin");
		obj.setLocation("location");
		obj.setName("name");
		obj.setPrice("1000");
		obj.setServicetime("service name");
		obj.setServicetime("2021 10 21");
		assertEquals(true, new MedicalPackages().update(obj));
	}

	@Test
	public void testMedicalPackagesView() throws ClassNotFoundException, SQLException {
		ArrayList<MedicalPackagesModel> mpList = new ArrayList<MedicalPackagesModel>();
		assertEquals(mpList, new MedicalPackages().read());
	}

	@Test
	public void testMedicalPackagesDelete() throws ClassNotFoundException, SQLException {
		assertEquals(true, new MedicalPackages().deletec(23));
	}

}
