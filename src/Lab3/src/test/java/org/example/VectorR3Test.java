package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VectorR3Test {

    private static final double EPSILON = 1e-9;

    // Length Tests

    @Test
    public void testLengthStandardVector() {
        VectorR3 v = new VectorR3(3.0, 4.0, 0.0);
        Assert.assertEquals(v.length(), 5.0, EPSILON, "Length of (3,4,0) must be 5.0");
    }

    @Test
    public void testLengthZeroVector() {
        VectorR3 v = new VectorR3(0.0, 0.0, 0.0);
        Assert.assertEquals(v.length(), 0.0, EPSILON, "Length of zero vector must be 0.0");
    }

    @Test
    public void testLengthNegativeCoordinates() {
        VectorR3 v = new VectorR3(-2.0, -3.0, -6.0);
        // sqrt((-2)^2 + (-3)^2 + (-6)^2) = sqrt(4 + 9 + 36) = sqrt(49) = 7
        Assert.assertEquals(v.length(), 7.0, EPSILON, "Length should ignore signs of coordinates");
    }

    // Orthogonality Tests

    @Test
    public void testAreOrthogonalWithStandardAxes() {
        VectorR3 v1 = new VectorR3(1.0, 0.0, 0.0);
        VectorR3 v2 = new VectorR3(0.0, 1.0, 0.0);
        Assert.assertTrue(VectorR3.areOrthogonal(v1, v2), "X and Y unit vectors must be orthogonal");
    }

    @Test
    public void testAreOrthogonalFalseForAcuteAngle() {
        VectorR3 v1 = new VectorR3(1.0, 1.0, 0.0);
        VectorR3 v2 = new VectorR3(1.0, 0.0, 0.0);
        Assert.assertFalse(VectorR3.areOrthogonal(v1, v2), "Vectors at 45 degrees must not be orthogonal");
    }

    // Equality Tests

    @Test
    public void testAreVectorsEqualExactMatch() {
        VectorR3 v1 = new VectorR3(1.0, 2.0, 3.0);
        VectorR3 v2 = new VectorR3(1.0, 2.0, 3.0);
        Assert.assertTrue(v1.areVectorsEqual(v1, v2), "Identical vectors must be equal");
    }

    @Test
    public void testAreVectorsEqualOppositeDirection() {
        VectorR3 v1 = new VectorR3(1.0, 2.0, 3.0);
        VectorR3 v2 = new VectorR3(-1.0, -2.0, -3.0);
        Assert.assertFalse(v1.areVectorsEqual(v1, v2), "Oppositely directed vectors must not be equal");
    }

    @Test
    public void testAreVectorsEqualWithinEpsilonTolerance() {
        VectorR3 v1 = new VectorR3(1.0, 2.0, 3.0);
        // Small variance below 1e-9 tolerance
        VectorR3 v2 = new VectorR3(1.0 + 1e-11, 2.0 - 1e-11, 3.0);
        Assert.assertTrue(v1.areVectorsEqual(v1, v2), "Vectors differing by less than EPSILON should evaluate as equal");
    }

    //  Intersection / Collinearity Tests

    @Test
    public void testIntersectsNonOrthogonalCollinearVectors() {
        VectorR3 v1 = new VectorR3(1.0, 2.0, 3.0);
        VectorR3 v2 = new VectorR3(2.0, 4.0, 6.0); // Scaled by 2
        Assert.assertTrue(v1.intersectsNonOrthogonal(v2), "Non-orthogonal collinear vectors should intersect");
    }

    @Test
    public void testIntersectsNonOrthogonalReturnsFalseWhenOrthogonal() {
        VectorR3 v1 = new VectorR3(1.0, 0.0, 0.0);
        VectorR3 v2 = new VectorR3(0.0, 1.0, 0.0);
        Assert.assertFalse(v1.intersectsNonOrthogonal(v2), "Must return false for orthogonal vectors");
    }

    // Coplanarity Tests

    @Test
    public void testAreCoplanarThreeVectorsInXYPlane() {
        VectorR3 v1 = new VectorR3(1.0, 0.0, 0.0);
        VectorR3 v2 = new VectorR3(0.0, 1.0, 0.0);
        VectorR3 v3 = new VectorR3(2.0, 3.0, 0.0);
        Assert.assertTrue(VectorR3.areCoplanar(v1, v2, v3), "All vectors with z=0 must be coplanar");
    }

    @Test
    public void testAreCoplanarLinearlyIndependentVectors() {
        VectorR3 v1 = new VectorR3(1.0, 0.0, 0.0);
        VectorR3 v2 = new VectorR3(0.0, 1.0, 0.0);
        VectorR3 v3 = new VectorR3(0.0, 0.0, 1.0);
        Assert.assertFalse(VectorR3.areCoplanar(v1, v2, v3), "Standard 3D basis vectors must not be coplanar");
    }
}