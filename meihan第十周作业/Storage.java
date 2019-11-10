package meihan第十周作业;


	import java.util.Random;

	class Storage {
			private String [] cells = new String[10];
			private int inpos,outpos;
			private int count;
			private String name;
			public synchronized void signIn () {
				try {
					while (count==cells.length) {
						this.wait();
					}
					Thread.sleep(new Random().nextInt(100));
					name=String.valueOf(new Random().nextInt(100));
					cells[inpos]=name;
					System.out.println("cells["+inpos+"]中用户"+cells[inpos]+"登录---在线人数："+count);
					inpos++;
					if (inpos==cells.length)
						inpos=0;
					count++;
					this.notify();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public  synchronized void logOut() {
				try {
					while (count==0) {
						this.wait();
					}
					Thread.sleep(new Random().nextInt(100));
					String data = cells[outpos];
					System.out.println("cells["+outpos+"]中用户"+data+"注销---在线人数："+count);
					cells[outpos]=null;
					outpos++;
					if(outpos==cells.length)
						outpos=0;
					count--;
					this.notify();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

	}


