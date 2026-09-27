package org.example;

public record VectorR3(double x, double y, double z) {

    public static final double EPSILON = 1e-9;
    public static boolean areOrthogonal(VectorR3 vec1, VectorR3 vec2) {
        double product = vec1.x() * vec2.x() + vec1.y() * vec2.y() + vec1.z() * vec2.z();
        return product == 0;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public boolean intersectsNonOrthogonal(VectorR3 other) {
        if (areOrthogonal(this,other)) {
            return false;
        }
        double crossX = this.y * other.z - this.z * other.y;
        double crossY = this.z * other.x - this.x * other.z;
        double crossZ = this.x * other.y - this.y * other.x;
        double crossLengthSq = crossX * crossX + crossY * crossY + crossZ * crossZ;

        return crossLengthSq < EPSILON;
    }

    public boolean areVectorsEqual(VectorR3 vec1, VectorR3 vec2) {
        if(vec1==vec2) return true;
        double vecLength1 = vec1.length();
        double vecLength2 = vec2.length();
        if (vecLength1 != vecLength2) return false;
        return Math.abs(vec1.x() - vec2.x()) < EPSILON
                && Math.abs(vec1.y() - vec2.y()) < EPSILON
                && Math.abs(vec1.z() - vec2.z()) < EPSILON;
    }

    public static boolean areCoplanar(VectorR3 a, VectorR3 b,VectorR3 c) {
        double det = a.x*(b.y*c.z-b.z*c.y)-a.y*(b.x*c.z-b.z*c.x) + a.z*(b.x*c.y-b.y*c.x);
        return Math.abs(det)< EPSILON;
    }
}
