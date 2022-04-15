package util;

import gui.frmLogeo;

public class HiloCloseLogin implements Runnable{
	
	private frmLogeo frmLogin;
	private boolean stop = false;
	
	public HiloCloseLogin(frmLogeo frmLogin) {
		this.frmLogin = frmLogin;
	}

	@Override
	public void run() {
		
		for (int i=30; i >= 0; i--) {			
			
			try {
				
				if (stop == true) {
					return;
				}
				
				Thread.sleep(1000);
				
				frmLogin.lblNewLabel_4.setText("Esta ventana se cerrará en " + i + " seg");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		frmLogin.dispose();
		
	}
	
	
	public void cancel() {
		stop = true;
	}
	
	
	
}
