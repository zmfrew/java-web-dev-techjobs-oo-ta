package org.launchcode.techjobs_oo.test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.main.*;

import javax.swing.text.Position;

import static org.junit.Assert.*;

public class JobTest {
    Job job1;
    Job job2;

    @Before
    public void setup() {
        job1 = new Job();
        job2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertTrue(job2.getId() > job1.getId());
        assertEquals(job2.getId(), job1.getId() + 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        assertNotEquals(job1, job2);
    }
}
