package meihan��ʮ����ҵ;

 
	class Input implements Runnable {
		private Storage st;
		Input (Storage st) {
			this.st=st;
		}
		public void run () {
			while (true) {
				st.signIn();
			}
		}
} 


