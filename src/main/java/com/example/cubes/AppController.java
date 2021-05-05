package com.example.cubes;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping("/home")
	public String brojForm(Model model) {
		
		Broj broj = new Broj();
		broj.setJmbg(null);
		model.addAttribute("broj", broj);
		
		return "home";
	}
	
	@RequestMapping("/check")
	public String homePage(@Valid @ModelAttribute Broj broj) {
		
		try {
		
		int dd, mm, yyy, rr, bbb, k;
		
//		if(broj.getJmbg().length()!=13)
//			broj.setIsValid(false);
		
		if(broj.getJmbg().contains(".*[a-z].*"))
			broj.setIsValid(false);
		
		dd = Integer.parseInt(broj.getJmbg().substring(0, 2));
		mm = Integer.parseInt(broj.getJmbg().substring(2, 4));
		yyy = Integer.parseInt(broj.getJmbg().substring(4, 7));
		rr = Integer.parseInt(broj.getJmbg().substring(7, 9));
		bbb = Integer.parseInt(broj.getJmbg().substring(9, 12));
		k = Integer.parseInt(broj.getJmbg().substring(12, 13));
		
		
		if(mm<1 || mm>12) {
			System.out.println("JMBG nije validan!");
			broj.setIsValid(false);
		}
		
		switch (mm) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if(dd<1 || dd>31) {
				System.out.println("JMBG nije validan!");
				broj.setIsValid(false);
			}
			
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if(dd<1 || dd>30) {
				System.out.println("JMBG nije validan!");
				broj.setIsValid(false);
			}
			break;
			
		case 2:
			if(yyy>600) {
				yyy = yyy + 1000;
			}
			else {
				yyy = yyy + 2000;
			}
			
			boolean checkYear = yyy%4 == 0 && (yyy%400==0 || yyy%100!=0);
			
			if(checkYear) {
				if(dd<1 || dd>29) {
					System.out.println("JMBG nije validan!");
					broj.setIsValid(false);
				}
			}
			else {
				if(dd<1 || dd>28) {
					System.out.println("JMBG nije validan!");
					broj.setIsValid(false);
				}
			}
			break;
		default:
			System.out.println("JMBG nije validan!");
			broj.setIsValid(false);
		}
		
		if(rr<70 || rr>100) {
			System.out.println("JMBG nije validan!");
			broj.setIsValid(false);
		}
		
		if(bbb<0 || bbb>999) {
			System.out.println("JMBG nije validan!");
			broj.setIsValid(false);
		}
		
		int a = Integer.parseInt(broj.getJmbg().substring(0, 1));
		int b = Integer.parseInt(broj.getJmbg().substring(1, 2));
		int c = Integer.parseInt(broj.getJmbg().substring(2, 3));
		int d = Integer.parseInt(broj.getJmbg().substring(3, 4));
		int e = Integer.parseInt(broj.getJmbg().substring(4, 5));
		int f = Integer.parseInt(broj.getJmbg().substring(5, 6));
		int g = Integer.parseInt(broj.getJmbg().substring(6, 7));
		int h = Integer.parseInt(broj.getJmbg().substring(7, 8));
		int i = Integer.parseInt(broj.getJmbg().substring(8, 9));
		int j = Integer.parseInt(broj.getJmbg().substring(9, 10));
		int l = Integer.parseInt(broj.getJmbg().substring(10, 11));
		int m = Integer.parseInt(broj.getJmbg().substring(11, 12));
		
		int control = 11 - ((7*(a+g) + 6*(b+h) + 5*(c+i) + 4*(d+j) + 3*(e+l) + 2*(f+m))%11);
		
		if(control>9) {
			control = 0;
		}
		
		if(control!=k) {
			System.out.println("JMBG nije validan!");
			broj.setIsValid(false);
			return "home";
		}
		//=============================================================
		String prvaCifra = String.valueOf(a);
		String drugaCifra = String.valueOf(b);
		String dan = prvaCifra+drugaCifra;
		
		String trecaCifra = String.valueOf(c);
		String cetvrtaCifra = String.valueOf(d);
		String mesec = trecaCifra+cetvrtaCifra;
		
		String godina;
		String petaCifra = String.valueOf(e);
		String sestaCifra = String.valueOf(f);
		String sedmaCifra = String.valueOf(g);
		if(petaCifra.contains("0"))
			godina = 2+petaCifra+sestaCifra+sedmaCifra;
		else
			godina = 1+petaCifra+sestaCifra+sedmaCifra;
		
		broj.setDatum(dan+"."+mesec+"."+godina+".");
		//==============================================================
		
		//==============================================================
		String ok = String.valueOf(rr);
		if(ok.contains("71"))
			broj.setOkrug("Beograd region");
		else if(ok.contains("72"))
			broj.setOkrug("Sumadija");
		else if(ok.contains("73"))
			broj.setOkrug("Nis");
		else if(ok.contains("74"))
			broj.setOkrug("Juzna Morava");
		else if(ok.contains("75"))
			broj.setOkrug("Zajecar");
		else if(ok.contains("76"))
			broj.setOkrug("Podunavlje");
		else if(ok.contains("77"))
			broj.setOkrug("Podrinje i Kolubara");
		else if(ok.contains("78"))
			broj.setOkrug("Kraljevo");
		else if(ok.contains("79"))
			broj.setOkrug("Uzice");
		else if(ok.contains("80"))
			broj.setOkrug("Novi Sad");
		else if(ok.contains("81"))
			broj.setOkrug("Sombor");
		else if(ok.contains("82"))
			broj.setOkrug("Subotica");
		else if(ok.contains("85"))
			broj.setOkrug("Zrenjanin");
		else if(ok.contains("86"))
			broj.setOkrug("Pancevo");
		else if(ok.contains("87"))
			broj.setOkrug("Kikinda");
		else if(ok.contains("88"))
			broj.setOkrug("Ruma");
		else if(ok.contains("89"))
			broj.setOkrug("Sremska Mitrovica");
		else if(ok.contains("91"))
			broj.setOkrug("Pristina");
		else if(ok.contains("92"))
			broj.setOkrug("Kosovska Mitrovica");
		else if(ok.contains("93"))
			broj.setOkrug("Pec");
		else if(ok.contains("94"))
			broj.setOkrug("Djakovica");
		else if(ok.contains("95"))
			broj.setOkrug("Prizren");
		else if(ok.contains("96"))
			broj.setOkrug("Kosovsko Pomoravski okrug");
		else
			broj.setIsValid(false);
		
		
		
		
		//==============================================================
		System.out.println("JMBG je validan!");
		broj.setIsValid(true);
		
		return "home";
		}catch(StringIndexOutOfBoundsException e){
			return "home";
		}
		catch (NumberFormatException e) {
			broj.setUnetoSlovo(true);
			broj.setIsValid(false);
			return "home";
		}
	}

}
