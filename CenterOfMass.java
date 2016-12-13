import java.util.Scanner;
/**
 * https://code.google.com/codejam/contest/189252/dashboard#s=p1
 * @author jake
 *
 */
public class CenterOfMass {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int n = in.nextInt();
			double x=0,y=0,z=0,vx=0,vy=0,vz=0;
			for(int i=0;i<n;i++) {
				x+=in.nextInt();
				y+=in.nextInt();
				z+=in.nextInt();
				vx+=in.nextInt();
				vy+=in.nextInt();
				vz+=in.nextInt();
			}
			x/=n;
			y/=n;
			z/=n;
			vx/=n;
			vy/=n;
			vz/=n;
			double verify = (vx*vx+vy*vy+vz*vz);
			double t;
			if(verify==0)
				t=0;
			else
				t = (-(x*vx)-(y*vy)-(z*vz))/verify;
			if(t<0) t=0;
			double d = Math.sqrt((x+vx*t)*(x+vx*t)+(y+vy*t)*(y+vy*t)+(z+vz*t)*(z+vz*t));		
			System.out.format("Case #"+(temp-tc)+": %.8f %.8f",d,t);
			System.out.println();
		}
		in.close();

	}

}
