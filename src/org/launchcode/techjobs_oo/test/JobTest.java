package org.launchcode.techjobs_oo.test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.main.*;

import javax.swing.text.Position;

import static org.junit.Assert.*;

public class JobTest {
    Job job1;
    Job job2;
    Job job3;

    @Before
    public void setup() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertTrue(job2.getId() > job1.getId());
        assertEquals(job2.getId(), job1.getId() + 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(job3.getName(), "Product tester");
        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(), "Quality control");
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        assertNotEquals(job1, job2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        char firstChar = job3.toString().charAt(0);
        char lastChar = job3.toString().charAt(job3.toString().length()-1);
        assertTrue(firstChar == lastChar);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String output = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n",job3.getId(), job3.getName(), job3.getEmployer(), job3.getLocation(),
                job3.getPositionType(), job3.getCoreCompetency());
        assertEquals(output, job3.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        job3.getEmployer().setValue("");
        job3.getPositionType().setValue("");
        String output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: Data not available\n" +
                "Location: %s\n" +
                "Position Type: Data not available\n" +
                "Core Competency: %s\n",job3.getId(), job3.getName(), job3.getLocation(), job3.getCoreCompetency());
        assertEquals(output, job3.toString());
    }
}
