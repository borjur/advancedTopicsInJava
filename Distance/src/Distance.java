//Distance class with feet and inches

public class Distance implements Comparable<Distance>
{
	private int feet;
	private int inches;
	private final int DEFAULT_FT = 1;
	private final int DEFAULT_IN = 1;

	//constructors	
	public Distance()
	{
		feet = DEFAULT_FT;
		inches = DEFAULT_IN;
	}

	public Distance( int ft, int in ) throws NegativeDistanceException
	{
                setFeet(ft);
                setInches(in);
	}
	
	//set methods - validate + whole integers only
        public void setFeet(int feet) throws NegativeDistanceException
        {
            if(feet < 0)
            {
                throw new NegativeDistanceException("Attempted to set negative feet value");
            }
            else 
            {
                this.feet = feet;
            }
        }
        
        public void setInches(int inches) throws NegativeDistanceException
        {
            if(inches < 0)
            {
                throw new NegativeDistanceException("Attempted to set negative inches value");
            }
            else if(inches < 12)
            {
                this.inches = inches;
            }
            else
            {
                feet += (inches / 12);
                this.inches = inches % 12;
            }
        }
	
	//get methods
        public int getFeet()
        {
            return feet;
        }
        
        public int getInches()
        {
            return inches;
        }
	
	//method to add two distance objects
        public Distance add(Distance other) throws NegativeDistanceException
        {
            Distance distance = new Distance(this.getFeet() + other.getFeet(), this.getInches() + other.getInches());
            
            return distance;
        }
	
	//method to subtract two distance objects
        public Distance sub(Distance other) throws NegativeDistanceException
        {
            if(this.compareTo(other) == 1)
            {
                int in = this.getInches() - other.getInches();
                int ft = this.getFeet() - other.getFeet();
                
                if(in < 0)
                {
                    ft = Math.abs(ft);
                    --ft;
                    in = 12 - Math.abs(in);
                }
                
                Distance distance = new Distance(Math.abs(ft), Math.abs(in));
            
                return distance;
            }
            else
            {
                return other.sub(this);
            }
        }
        
        //hashcode()
        @Override
        public int hashCode()
        {
            int result = 17;
            result = result * 37 + inches;
            result = result * 37 + feet;
            return result;
        }
	
	//equals() - compares two distance objects for equality
        @Override
        public boolean equals(Object object)
        {
            if(object == null) return false;
            
            if(this == object) return true;
            
            if(!(object instanceof Distance)) return false;
            
            Distance second = (Distance)object;
            
            if(this.getFeet() != second.getFeet()
                    || this.getInches() != second.getInches())
                return false;
            
            return true;
        }
	
	//compareTo() - compares two distance objects ( <, > )
	@Override
        public int compareTo(Distance other)
        {
            if(this.equals(other))
            {
                return 0;
            }
            else if(this.getFeet() > other.getFeet())
            {
                return 1;
            }
            else if(this.getFeet() == other.getFeet() && this.getInches() > other.getInches())
            {
                return 1;
            }
            else 
            {
                return -1;
            }
        }
        
	@Override
	public String toString()
	{
		return String.format("%d' %d\"", feet, inches );
	}
	
}