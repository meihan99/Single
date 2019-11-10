package meihan第十周作业;


	class Output implements Runnable {
		private Storage st;

		Output (Storage st ) {
			this.st =st ;
		}
		public void run () {
			while (true ) {
				st.logOut();
			}
		}
} 


