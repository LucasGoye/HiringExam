package com.goyeneche;

import com.goyeneche.models.Meeting;
import com.goyeneche.models.Room;
import com.goyeneche.models.Student;
import com.goyeneche.models.Subject;
import com.goyeneche.services.MeetingService;
import com.goyeneche.services.RoomService;
import com.goyeneche.services.StudentService;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        List<Student> students = studentService.getStudents();

        // Exercise 1B
        System.out.println("1B");
        System.out.println();


        System.out.println(studentService.studentGroupByLastName(students));

        System.out.println("=========================================");
        System.out.println();

        // Exercise 1C
        System.out.println("1C");
        System.out.println();
        Subject math = new Subject(1L, "Math");
        math.addStudent(students.get(2));
        math.addStudent(students.get(2));
        math.addStudent(students.get(4));
        math.addStudent(students.get(5));
        math.addStudent(students.get(5));
        math.addStudent(students.get(8));
        System.out.println(studentService.getbySubject(math).stream().distinct().collect(Collectors.toList()));

        System.out.println("=========================================");
        System.out.println();

        // Exercise 2C
        System.out.println("2C");
        System.out.println();

        MeetingService meetingService = new MeetingService();

        Room room1 = new Room(1l, "Room 1", "Room 1 desc");
        Room room2 = new Room(2l, "Room 2", "Room 2 desc");

        // Validated for 1 room
        Meeting meeting1 = new Meeting(1l, students.get(0),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 10, 0),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 10, 30), room1);
        Meeting meeting2 = new Meeting(2l, students.get(0),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 10, 30),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 11, 0), room1);
        Meeting meeting3 = new Meeting(3l, students.get(0),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 11, 0),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 11, 30), room1);
        Meeting meeting4 = new Meeting(4l, students.get(0),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 11, 30),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 12, 0), room1);

        System.out.println(meetingService.validateSchedule(Arrays.asList(meeting1, meeting2, meeting3, meeting4)));
        System.out.println();

        // Validated for 2 rooms
        Meeting meeting5 = new Meeting(5l, students.get(0),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 10, 0),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 10, 30), room2);
        Meeting meeting6 = new Meeting(6l, students.get(0),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 10, 30),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 11, 0), room2);

        System.out.println(meetingService.validateSchedule(Arrays.asList(meeting1, meeting2, meeting3, meeting4, meeting5, meeting6)));
        System.out.println();

        // Not validated
        Meeting meeting7 = new Meeting(7l, students.get(0),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 10, 0),
                LocalDateTime.of(2021, Calendar.APRIL, 5, 10, 30), room1);

        System.out.println(meetingService.validateSchedule(Arrays.asList(meeting1, meeting2, meeting3, meeting4, meeting5, meeting6, meeting7)));
        System.out.println();

    }
}
