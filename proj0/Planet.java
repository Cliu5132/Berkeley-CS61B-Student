public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    public Planet (Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance (Planet p) {
        return  Math.sqrt(Math.pow(this.xxPos - p.xxPos, 2) + Math.pow(this.yyPos - p.yyPos, 2));
    }

    /** Total Force */
    public double calcForceExertedBy (Planet p) {
        /** Constant Gravity */
        double G = 6.67e-11;
        double r = calcDistance(p);
        return G * this.mass * p.mass / Math.pow(r, 2);
    }

    /** X direction Force */
    public double calcForceExertedByX (Planet p) {
        double F = calcForceExertedBy(p);
        double r = calcDistance(p);
        return F * (p.xxPos - this.xxPos)/r;
    }

    /** Y direction Force */
    public double calcForceExertedByY (Planet p) {
        double F = calcForceExertedBy(p);
        double r = calcDistance(p);
        return F * ( p.yyPos - this.yyPos)/r;
    }

    /** Total Force */
    public double calcNetForceExertedByX (Planet[] ps) {
        double netForceByX = 0;
        for(Planet p:ps){
            if(!p.equals(this))
                netForceByX += calcForceExertedByX(p);
        }
        return netForceByX;
    }
    public double calcNetForceExertedByY (Planet[] ps) {
        double netForceByY = 0;
        for(Planet p:ps){
            if(!p.equals(this))
                netForceByY += calcForceExertedByY(p);
        }
        return netForceByY;
    }
    /** Update v, a */
    public void update (double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;

        this.xxVel = this.xxVel + dt * aX;
        this.yyVel = this.yyVel + dt * aY;

        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "./images/"+this.imgFileName);
    }
}