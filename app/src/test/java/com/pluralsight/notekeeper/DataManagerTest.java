package com.pluralsight.notekeeper;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataManagerTest {

  private static DataManager sDataManager;

  @BeforeClass
  public static void classSetUp() throws Exception {
    sDataManager = DataManager.getInstance();
  }

  @Before
  public void setUp() throws Exception {
    sDataManager.getNotes().clear();
    sDataManager.initializeExampleNotes();
  }

  @Test
  public void createNewNote() {
    final CourseInfo course = sDataManager.getCourse("android_async");
    final String noteTitle = "Test note title";
    final String noteText = "This is the body text of my test note";

    int noteIndex = sDataManager.createNewNote();
    NoteInfo info = sDataManager.getNotes().get(noteIndex);
    info.setCourse(course);
    info.setTitle(noteTitle);
    info.setText(noteText);

    NoteInfo compareNote = sDataManager.getNotes().get(noteIndex);
    assertEquals(compareNote.getCourse(), course);
    assertEquals(compareNote.getTitle(), noteTitle);
    assertEquals(compareNote.getText(), noteText);
  }

  @Test
  public void createNewNoteOneStepCreation() {
    final CourseInfo course = sDataManager.getCourse("android_async");
    final String noteTitle = "Test note title";
    final String noteText = "This is the body text of my test note";

    int noteIndex = sDataManager.createNewNote(course, noteTitle, noteText);

    NoteInfo compareNote = sDataManager.getNotes().get(noteIndex);
    assertEquals(compareNote.getCourse(), course);
    assertEquals(compareNote.getTitle(), noteTitle);
    assertEquals(compareNote.getText(), noteText);
  }
}
