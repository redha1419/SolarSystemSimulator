package planets;

public class Planet extends Orbit{
		private double mass;
		private double radius;
		private double diameter;
		private String color;
		private double speed;
		private double distance;
		private String name;
		private float rotPerSec;
		private final float DISTANCE = ((float)(5913*1000*(Math.pow(10, 6))))/6.87f;

		// constructor
		public Planet(){
			mass = 0;
			radius = 0;
			diameter = 0;
			color = "";
			speed = 0;
			distance = 0;
			name = "";
			rotPerSec = 0f;
			}

		public Planet(String n, double m, double r, double d, String c, double s, double d1,float rotY){
			mass = m;
			mass = mass * (Math.pow(10, 24));
			radius = r;
			radius = radius *1000;
			diameter = d;
			diameter = diameter *1000;
			color = c;
			speed = s;
			speed = speed *1000;
			distance = d1;
			distance = distance * 1000 * (Math.pow(10, 6));
			name = n;
			rotPerSec = rotY;
			}


	
		//Mutators_1
		public float getDistanceRatio(){
			if(this.getDistance()!=0){
			return (float) (this.getDistance()/DISTANCE)+1f;
			}
			else{
				return 0;
			}
		}
		public float getScale(){
			float scale = (float) (this.getRadius()/(695700*1000));
			return scale;
		}

		//Accessors

		public double getMass(){
			return mass;
		}
		public double getRadius(){
			return radius;
		}
		public double getDiameter(){
			return diameter;
		}
		public String getColor(){
			return color;
		}
		public double getSpeed(){
			return speed;
		}
		public double getDistance(){
			return distance;
		}
		public String getName(){
			return name;
		}

		public float getRotPerSec() {
			return rotPerSec;
		}

		public void setRotPerSec(float rot_per_sec) {
			rotPerSec = rot_per_sec;
		}
		public void setColor(String c){
			this.color = c;
		}

	}
