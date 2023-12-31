	package trashcash;
	
	import javax.swing.ImageIcon;
	
	public class LodgesDataBase {
		
			// Barangays
		 	String[] barangays = {"Kalubihan", "Pahina Central", "Lahug", "Zapatera", "Mambaling", "Punta", "Tisa", "Labangon", "Basak San Nicholas", "Day-as", "Sambag 2", "Cogon Ramos", "Kamputhaw"};
		 	// Lodges sa mga Barangay
		    String[][] lodges = {
		    					 {"SOGO Hotel" ,"TMS Lodge", "ALEMAR Budgetel", "Best Inn", "Hope Pension House"}, 
		    					 {"TMS Lodge Pahina", "KSL Lodge", "Kean's Lodge", "Q-Hotel", ""},
		    					 {"Cebu Guest Inn", "Wjv Inn Lahug", "Queensland", "Cebu Leisure Lodge", "OYO Sugbo Leisure Lodge"},
		    					 {"Palazzo Pensionne","TravelBee Business Inn", "Shejoje Poshtel Cebu", "Sans Hotel", "Soleil Suites"},
		    					 {"Queensland","GS Tourist Inn","OYO 673 Mambaling Pension 2", "OYO 655 Mambaling Pension", ""},
		    					 {"Jomer's Lodge", "Bertlee's Pension Hauz", "OYO 157 Venna Pension House", "", ""},
		    					 {"OYO 491 J", "Kiwi South", "", "", ""},
		    					 {"Jomer's Lodge", "OYO 925 Rcee Place", "7 Days Inn", "", ""},
		    					 {"Red Doorz", "Westview Pension", "Kryst Tourist Inn", "", ""},
		    					 {"Frankfurter Deluxe Inn", "RedDoorz", "", "", ""},
		    					 {"Seven Archangels Pension House", "Arbel Lodging House", "Fuente Pension House", "OYO 982 Boulevard Pension House", ""},
		    					 {"RF Suites", "KC 1-Bedroom @ Horizon 101", "JDT's Condo @ Horizons 101", "", ""},
		    					 {"Cebu Pension Plaza", "MJ Hotel and Suites", "St. Mark Hotel", "Cebu Pension Plaza", ""},
		    					 };
		    String[][] lodgesLocations = {
		    								{"Sanciangko St., Kalubihan, Cebu City, Besides Cebuana Lhuiller","Sanciangko St., Kalubihan, Cebu City", "Corner P. Lopez St., Kalubihan, Cebu City", "Corner P. Lopez St. and Balintawak, Kalubihan, Cebu City","Colon St., Kalubihan, Cebu City, Besides at Kara’s Fried Chicken"},
		    								{"Leon Kilat St., Pahina Central, Cebu City","Corner A. Borromeo St. and Leon Kilat St., Pahina Central, Cebu City", "Leon Kilat St., Pahina Central, Cebu City","Leon Kilat St., Pahina Central, Cebu City", ""},
		    								{"Holy Family Rd, Cebu City, 6000 Cebu","Avc bldg, Salinas Dr, Apas", "Sanson Road, Lahug, Cebu City",":  v. rama ave. english, cebu, Cebu City", "Englis V. Rama Ave., Cebu City, Philippines"},
		    								{"General Echavez St, Cebu City","D. Jakosalem St, Cebu City, 6000 Cebu", " Dionisio Jakosalem St, Cebu City, 6000 Cebu","192 General Echavez St, Cebu City, 6000 Cebu", "197 Rahmann St, Cebu City, 6000 Cebu"},
		    								{"Cebu City, 6000 Cebu","Cashmere St, Cebu City", " Balud St, Cebu City, 6000 Cebu","13 Bayabas St, Cebu City, 6000 Cebu", ""},
		    								{"Queblar corner Flancia Street","Francisco Llamas Street, Mambaling, Cebu City", "Punta Princesa San Lorenzo Village, E Sabellano Street, Cebu City, 6000 Cebu","", ""},
		    								{"Near CEERS REVIEW CENTER, Cebu City, 6000 Cebu","466 Francisco Llamas St, Cebu City, 6000 Cebu","", "", ""},
		    								{"Leon Kilat St., Pahina Central, Cebu City","Corner A. Borromeo St. and Leon Kilat St., Pahina Central, Cebu City", "Leon Kilat St., Pahina Central, Cebu City","Leon Kilat St., Pahina Central, Cebu City", ""},
		    								{"Leon Kilat St., Pahina Central, Cebu City","Corner A. Borromeo St. and Leon Kilat St., Pahina Central, Cebu City", "Leon Kilat St., Pahina Central, Cebu City","Leon Kilat St., Pahina Central, Cebu City", ""},
		    								{"Leon Kilat St., Pahina Central, Cebu City","Corner A. Borromeo St. and Leon Kilat St., Pahina Central, Cebu City", "Leon Kilat St., Pahina Central, Cebu City","Leon Kilat St., Pahina Central, Cebu City", ""},
		    								{"Leon Kilat St., Pahina Central, Cebu City","Corner A. Borromeo St. and Leon Kilat St., Pahina Central, Cebu City", "Leon Kilat St., Pahina Central, Cebu City","Leon Kilat St., Pahina Central, Cebu City", ""},
		    								{"Leon Kilat St., Pahina Central, Cebu City","Corner A. Borromeo St. and Leon Kilat St., Pahina Central, Cebu City", "Leon Kilat St., Pahina Central, Cebu City","Leon Kilat St., Pahina Central, Cebu City", ""},
		    								{"Leon Kilat St., Pahina Central, Cebu City","Corner A. Borromeo St. and Leon Kilat St., Pahina Central, Cebu City", "Leon Kilat St., Pahina Central, Cebu City","Leon Kilat St., Pahina Central, Cebu City", ""},
		    								
		    							};
		    String contactnumber[] = {"096321455","0931034645", "452-4645-800", "556-789-624", "098975663", "744-550-348"};
		    String rate[] = {"Rate: PHP 399/ 4 Hours", "Rate: PHP 400/ 4 Hours", "Rate: PHP 800/ 4 Hours", "Rate: PHP 550/ 4 Hours", "Rate: PHP 350/ 4 Hours"};
		    
		    ImageIcon img1 = new ImageIcon("showLodge.jpg");
		    ImageIcon img2 = new ImageIcon("showLodge.jpg");
		    ImageIcon img3 = new ImageIcon("showLodge.jpg");
		    ImageIcon img4 = new ImageIcon("showLodge.jpg");
		    ImageIcon img5 = new ImageIcon("showLodge.jpg");
		    // Kalubihan
		    ImageIcon Kalubihanimg1 = new ImageIcon("Sogo.jpg");
		    ImageIcon Kalubihanimg2 = new ImageIcon("TMSlodge.jpg");
		    ImageIcon Kalubihanimg3 = new ImageIcon("alemarbudgetel.jpg");
		    ImageIcon Kalubihanimg4 = new ImageIcon("BESTINN.jpg");
		    ImageIcon Kalubihanimg5 = new ImageIcon("HPH.jpg");
		    
		    // Pahina Central
		    ImageIcon Pahinaimg1 = new ImageIcon("TMSlodge.jpg");
		    ImageIcon Pahinaimg2 = new ImageIcon("KSL.png");
		    ImageIcon Pahinaimg3 = new ImageIcon("BESTINN.jpg");
		    ImageIcon Pahinaimg4 = new ImageIcon("qhotel.jpg");
		    ImageIcon Pahinaimg5 = new ImageIcon("oyo982.jpg");
		    
		    // Lahug
		    ImageIcon Lahugimg1 = new ImageIcon("cebuguesstinn.jpg");
		    ImageIcon Lahugimg2 = new ImageIcon("showLodge.jpg");
		    ImageIcon Lahugimg3 = new ImageIcon("showLodge.jpg");
		    ImageIcon Lahugimg4 = new ImageIcon("showLodge.jpg");
		    ImageIcon Lahugimg5 = new ImageIcon("showLodge.jpg");
		    
		    // Zapatera
		    ImageIcon Zapateraimg1 = new ImageIcon("showLodge.jpg");
		    ImageIcon Zapateraimg2 = new ImageIcon("showLodge.jpg");
		    ImageIcon Zapateraimg3 = new ImageIcon("showLodge.jpg");
		    ImageIcon Zapateraimg4 = new ImageIcon("showLodge.jpg");
		    ImageIcon Zapateraimg5 = new ImageIcon("showLodge.jpg");
		    
		    // Mambaling
		    ImageIcon Mambalingimg1 = new ImageIcon("showLodge.jpg");
		    ImageIcon Mambalingimg2 = new ImageIcon("showLodge.jpg");
		    ImageIcon Mambalingimg3 = new ImageIcon("showLodge.jpg");
		    ImageIcon Mambalingimg4 = new ImageIcon("showLodge.jpg");
		    ImageIcon Mambalingimg5 = new ImageIcon("showLodge.jpg");
		    
		    // Punta
		    ImageIcon Puntaimg1 = new ImageIcon("showLodge.jpg");
		    ImageIcon Puntaimg2 = new ImageIcon("showLodge.jpg");
		    ImageIcon Puntaimg3 = new ImageIcon("showLodge.jpg");
		    ImageIcon Puntaimg4 = new ImageIcon("showLodge.jpg");
		    ImageIcon Puntaimg5 = new ImageIcon("showLodge.jpg");
		    
		    // Tisa
		    ImageIcon Tisaimg1 = new ImageIcon("showLodge.jpg");
		    ImageIcon Tisaimg2 = new ImageIcon("showLodge.jpg");
		    ImageIcon Tisaimg3 = new ImageIcon("showLodge.jpg");
		    ImageIcon Tisaimg4 = new ImageIcon("showLodge.jpg");
		    ImageIcon Tisaimg5 = new ImageIcon("showLodge.jpg");
		    
		    // Labangon
		    ImageIcon Labangonimg1 = new ImageIcon("showLodge.jpg");
		    ImageIcon Labangonimg2 = new ImageIcon("showLodge.jpg");
		    ImageIcon Labangonimg3 = new ImageIcon("showLodge.jpg");
		    ImageIcon Labangonimg4 = new ImageIcon("showLodge.jpg");
		    ImageIcon Labangonimg5 = new ImageIcon("showLodge.jpg");
		    
		    // Basak
		    ImageIcon Basakimg1 = new ImageIcon("showLodge.jpg");
		    ImageIcon Basakimg2 = new ImageIcon("showLodge.jpg");
		    ImageIcon Basakimg3 = new ImageIcon("showLodge.jpg");
		    ImageIcon Basakimg4 = new ImageIcon("showLodge.jpg");
		    ImageIcon Basakimg5 = new ImageIcon("showLodge.jpg");
		    
		    //Day-as
		    ImageIcon Dayasimg1 = new ImageIcon("showLodge.jpg");
		    ImageIcon Dayasimg2 = new ImageIcon("showLodge.jpg");
		    ImageIcon Dayasimg3 = new ImageIcon("showLodge.jpg");
		    ImageIcon Dayasimg4 = new ImageIcon("showLodge.jpg");
		    ImageIcon Dayasimg5 = new ImageIcon("showLodge.jpg");
		    
		    // Sambag2
		    ImageIcon Sambag2img1 = new ImageIcon("showLodge.jpg");
		    ImageIcon Sambag2img2 = new ImageIcon("showLodge.jpg");
		    ImageIcon Sambag2img3 = new ImageIcon("showLodge.jpg");
		    ImageIcon Sambag2img4 = new ImageIcon("showLodge.jpg");
		    ImageIcon Sambag2img5 = new ImageIcon("showLodge.jpg");
		    
		    // Cogon
		    ImageIcon Cogonimg1 = new ImageIcon("showLodge.jpg");
		    ImageIcon Cogonimg2 = new ImageIcon("showLodge.jpg");
		    ImageIcon Cogonimg3 = new ImageIcon("showLodge.jpg");
		    ImageIcon Cogonimg4 = new ImageIcon("showLodge.jpg");
		    ImageIcon Cogonimg5 = new ImageIcon("showLodge.jpg");
		    
		    // Kamputhaw
		    ImageIcon Kamputhawimg1 = new ImageIcon("showLodge.jpg");
		    ImageIcon Kamputhawimg2 = new ImageIcon("showLodge.jpg");
		    ImageIcon Kamputhawimg3 = new ImageIcon("showLodge.jpg");
		    ImageIcon Kamputhawimg4 = new ImageIcon("showLodge.jpg");
		    ImageIcon Kamputhawimg5 = new ImageIcon("showLodge.jpg");
		    
		    
		    
		    ImageIcon[][] lodgePictures = {
		    								{Kalubihanimg1,Kalubihanimg2,Kalubihanimg3,Kalubihanimg4,Kalubihanimg5},
		    								{Pahinaimg1,Pahinaimg2,Pahinaimg3,Pahinaimg4,Pahinaimg5},
		    								{Lahugimg1,Lahugimg2,Lahugimg3,Lahugimg4,Lahugimg5},
		    								{Zapateraimg1,Zapateraimg2,Zapateraimg3,Zapateraimg4,Zapateraimg5},
		    								{Mambalingimg1,Mambalingimg2,Mambalingimg3,Mambalingimg4,Mambalingimg5},
		    								{Puntaimg1,Puntaimg2,Puntaimg3,Puntaimg4,Puntaimg5},
		    								{Tisaimg1,Tisaimg2,Tisaimg3,Tisaimg4,Tisaimg5},
		    								{Labangonimg1,Labangonimg2,Labangonimg3,Labangonimg4,Labangonimg5},
		    								{Basakimg1,Basakimg2,Basakimg3,Basakimg4,Basakimg5},
		    								{Dayasimg1,Dayasimg2,Dayasimg3,Dayasimg4,Dayasimg5},
		    								{Sambag2img1,Sambag2img2,Sambag2img3,Sambag2img4,Sambag2img5},
		    								{Cogonimg1,Cogonimg2,Cogonimg3,Cogonimg4,Cogonimg5},
		    								{Kamputhawimg1,Kamputhawimg2,Kamputhawimg3,Kamputhawimg4,Kamputhawimg5}};
		    					
	}
