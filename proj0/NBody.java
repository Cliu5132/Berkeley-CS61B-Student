public class NBody {
    public static double readRadius (String filePath) {
        In in = new In(filePath);
        in.readInt();
		double secondItemInFile = in.readDouble();

        return secondItemInFile;
    }

    public static Planet[] readPlanets (String filePath) {
        In in = new In(filePath);
        int count = in.readInt();
        in.readDouble();

        Planet[] ps = new Planet[count];

        for(int i=0;i<count;i++) {
            /** Planet inputs */
            double xP =in.readDouble();
            double yP =in.readDouble();
            double vX =in.readDouble();
            double vY =in.readDouble();
            double m  =in.readDouble();
            String img=in.readString();

            ps[i] = new Planet(xP, yP, vX, vY, m, img);
        }

        return ps;
    }
    public static void main(String[] args) {

        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        
        double r = readRadius(filename);

        Planet[] ps = readPlanets(filename);

        /** Enable double buffering */
        StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(-r, r);
		StdDraw.setYscale(-r, r);

        /**Create a time variable and set it to 0. Set up a loop to loop until this time variable is T. */
        for(int i=0; i<T; i+=dt){
            double[] xForces = new double[ps.length];
            double[] yForces = new double[ps.length];

            for(int j=0;j<ps.length;j++) {
                xForces[j]=ps[j].calcNetForceExertedByX(ps);
                yForces[j]=ps[j].calcNetForceExertedByY(ps);
            }
            for(int j=0;j<ps.length;j++) {
                ps[j].update(dt, xForces[j], yForces[j]);
            }

            /** Draw Background */
            drawBG();
            /** Draw all of the planets */
            for(Planet p: ps) {
                p.draw();
            }
            /** Show all offscreen buffer */
            StdDraw.show();
            /** Pause 10 millisceonds or longer, this depends on your machine screen refresh rate */
            StdDraw.pause(1);
        }

        printFinal(ps, r);
    }

    private static void drawBG() {
        String imageToDraw = "./images/starfield.jpg";
        StdDraw.picture(0,0,imageToDraw);
    }

    private static void printFinal(Planet[] ps, double r) {
        /** Print out the final state before end */
        StdOut.printf("%d\n", ps.length);
        StdOut.printf("%.2e\n", r);
        for (Planet p: ps) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",  
                p.xxPos, p.yyPos, p.xxVel,
                p.yyVel, p.mass, p.imgFileName);
        }
    }
}
