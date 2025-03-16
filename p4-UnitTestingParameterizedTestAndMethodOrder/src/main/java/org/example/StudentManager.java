// Kelas utama untuk diuji: StudentManager.java
 package org.example;

import org.example.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // Menambahkan student baru
    public boolean addStudent(String name, int age, String major) {
        if (name == null || name.isEmpty() || age < 16 || age > 60 || major == null || major.isEmpty()) {
            return false;
        }

        Student student = new Student(name, age, major);
        return students.add(student);
    }

    // Memeriksa apakah mahasiswa lulus berdasarkan nilai
    public String checkGradeStatus(double grade) {
        if (grade < 0 || grade > 100) {
            return "Invalid Grade";
        } else if (grade >= 80) {
            return "A";
        } else if (grade >= 70) {
            return "B";
        } else if (grade >= 60) {
            return "C";
        } else if (grade >= 50) {
            return "D";
        } else {
            return "E";
        }
    }

    // Memeriksa apakah mahasiswa diterima berdasarkan skor tes
    public boolean isAccepted(int mathScore, int englishScore, int scienceScore) {
        // Minimal rata-rata skor 70 dan tidak ada nilai di bawah 60
        double average = (mathScore + englishScore + scienceScore) / 3.0;
        return average >= 70 && mathScore >= 60 && englishScore >= 60 && scienceScore >= 60;
    }

    // Mendapatkan daftar mata kuliah berdasarkan jurusan
    public List<String> getSubjectsByMajor(String major) {
        List<String> subjects = new ArrayList<>();

        switch (major.toLowerCase()) {
            case "computer science":
                subjects.add("Programming");
                subjects.add("Database");
                subjects.add("Algorithm");
                subjects.add("Networking");
                break;
            case "mathematics":
                subjects.add("Calculus");
                subjects.add("Linear Algebra");
                subjects.add("Statistics");
                subjects.add("Discrete Mathematics");
                break;
            case "physics":
                subjects.add("Mechanics");
                subjects.add("Electricity");
                subjects.add("Thermodynamics");
                subjects.add("Modern Physics");
                break;
            default:
                subjects.add("No specific subjects found");
        }

        return subjects;
    }

    // Memfilter mahasiswa berdasarkan kriteria usia
        public List<Student> filterStudentsByAgeRange(int minAge, int maxAge) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() >= minAge && student.getAge() <= maxAge) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    // Cek apakah mahasiswa memenuhi syarat untuk beasiswa
    public boolean isEligibleForScholarship(double gpa, int researchPapers, boolean hasActivities) {
        if (gpa >= 3.5 && researchPapers >= 2) {
            return true;
        }

        if (gpa >= 3.0 && researchPapers >= 1 && hasActivities) {
            return true;
        }

        return false;
    }

    // Mendapatkan semua mahasiswa
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    // Menghapus semua mahasiswa (untuk keperluan testing)
    public void clearAllStudents() {
        students.clear();
    }
}