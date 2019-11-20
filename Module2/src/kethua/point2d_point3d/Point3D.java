package kethua.point2d_point3d;

public class Point3D extends Point2D {
    private float z;

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setX(x);
        super.setY(y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] xyz = {super.getX(), super.getY(), this.z};
        return xyz;
    }

    public Point3D() {

    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D{" + this.getX() + "," + this.getY() + "," + this.getZ() + "}";
    }
}
