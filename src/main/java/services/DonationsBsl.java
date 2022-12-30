package services;

import org.springframework.stereotype.Service;

@Service
public class DonationsBsl {
	static 	Schools schools; // 10
	static CancerHospital hospital; //57357
	static NGOs ngos;  
		public DonationsBsl() {
			schools = new Schools();
			hospital = new CancerHospital();
			ngos  = new NGOs();
		}
		
		public static CancerHospital getCancerHospital() {
			return hospital;
		}
		public static Schools getSchools() {
			return schools ;
		}
		public static NGOs getNGOs() {
			return ngos ;
		}
		public static String transact(int providerId, int amount) {
			if(providerId == 10) {
				schools.setTotalTransactionAmount(schools.getTotalTransactionAmount() + amount);
				return "Shools  \n" ;
			}
			else if(providerId == 57357){
				hospital.setTotalTransactionAmount(hospital.getTotalTransactionAmount() + amount);
				return "Cancer Hosiptal \n" ;
			}
			else if(providerId == 5){
				ngos.setTotalTransactionAmount(ngos.getTotalTransactionAmount() + amount);
				return "NGOs \n" ;
			}

			else {
				return "orgnization not found";
			}
		}

		public static boolean check(int providerId) {
			if(providerId==10 || providerId==57357 || providerId==5 ) {
				return true;
			}
			return false;
		}
}
