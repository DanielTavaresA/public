
/**
 * Write the specification here
 */
public final class Vector3 {

    private int x;
    private int y;
    private int z;

    public Vector3(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean isNull(){
        return true;
    };
    public int dot(Vector3 a, Vector3 b){
        return 0;
    };

    public int length(){
        return 0;
    }

    public Vector3 cross(Vector3 a, Vector3 b){
        return new Vector3(0,0,0);
    }

    public void normalize(){

    }

    public void scale(int a){

    }


}
