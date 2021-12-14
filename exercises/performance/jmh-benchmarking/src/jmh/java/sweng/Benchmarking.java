package sweng;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(2)
@State(Scope.Benchmark)
public class Benchmarking {

/*    @Benchmark
    public void dummyBenchmark(Blackhole bh) {
        int addition = 1 + 1;
        bh.consume(addition); // No dead code
    }*/


/*    @Benchmark
    public void studentCacheReaderBenchmark(Blackhole bh){
        CSVReader reader = new CSVReader("res/students.txt", new StudentCache());
        for (int i = 0; i < 5; i++) {
            bh.consume(reader.read(10));
        }

    }

    @Benchmark
    public void uselessCacheReaderBenchmark(Blackhole bh){
        CSVReader reader = new CSVReader("res/students.txt", new UselessCache());
        for (int i = 0; i < 5; i++) {
            bh.consume(reader.read(10));
        }
    }

    @Benchmark
    public void streamBenchmark(Blackhole bh){
        CSVReader reader = new CSVReader("res/students.txt", new UselessCache());
        List<Student> students = new ArrayList<>(reader.read(1000));
        for (int i = 0; i < 1000; i++) {
            students.addAll(reader.read(1000));
        }
        bh.consume(students.stream().map(Student::getEmail).collect(Collectors.toList()));
    }

    @Benchmark
    public void streamParallelBenchmark(Blackhole bh){
        CSVReader reader = new CSVReader("res/students.txt", new UselessCache());
        List<Student> students = new ArrayList<>(reader.read(1000));
        for (int i = 0; i < 1000; i++) {
            students.addAll(reader.read(1000));
        }
        bh.consume(students.stream().parallel().map(Student::getEmail).collect(Collectors.toList()));
    }*/
  /*  @Benchmark
    public void listBenchmark(Blackhole bh){
        CSVReader reader = new CSVReader("res/students.txt", new UselessCache());
        List<Student> students = new ArrayList<>(reader.read(1000));
        for (int i = 0; i < 1000; i++) {
            bh.consume(students.contains(new Student("Adlai", "Bodicum",	"abodicumom@cpanel.net", "Konyang University")));
        }

    }

    @Benchmark
    public void setBenchmark(Blackhole bh){
        CSVReader reader = new CSVReader("res/students.txt", new UselessCache());
        Set<Student> students = new HashSet<>(reader.read(1000));
        for (int i = 0; i < 1000; i++) {
            bh.consume(students.contains(new Student("Adlai", "Bodicum",	"abodicumom@cpanel.net", "Konyang University")));
        }

    }*/

/*    @Benchmark
    public void forIBenchmark(Blackhole bh){
        CSVReader reader = new CSVReader("res/students.txt", new UselessCache());
        List<Student> students = new LinkedList<>(reader.read(1000));
        for (int i = 0; i < 1000; i++) {
            bh.consume(students.get(i));
        }
    }

    @Benchmark
    public void forEachBenchmark(Blackhole bh){
        CSVReader reader = new CSVReader("res/students.txt", new UselessCache());
        List<Student> students = new LinkedList<>(reader.read(1000));
        for (Student student : students) {
            bh.consume(student);
        }
    }*/

    @Benchmark
    public void forIArrayBenchmark(Blackhole bh){
        CSVReader reader = new CSVReader("res/students.txt", new UselessCache());
        List<Student> students = new ArrayList<>(reader.read(1000));
        for (int i = 0; i < 1000; i++) {
            bh.consume(students.get(i));
        }
    }

    @Benchmark
    public void forEachArrayBenchmark(Blackhole bh){
        CSVReader reader = new CSVReader("res/students.txt", new UselessCache());
        List<Student> students = new ArrayList<>(reader.read(1000));
        for (Student student : students) {
            bh.consume(student);
        }
    }

}
