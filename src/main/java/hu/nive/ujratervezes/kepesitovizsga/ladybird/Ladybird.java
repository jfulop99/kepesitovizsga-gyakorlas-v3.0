package hu.nive.ujratervezes.kepesitovizsga.ladybird;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Ladybird {

    private DataSource dataSource;

    public Ladybird(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getLadybirdsWithExactNumberOfPoints(int numberOfPoints) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select hungarian_name as result from ladybirds where number_of_points = ?")){
            ps.setInt(1, numberOfPoints);
            return getResultByPoints(ps);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }

    }

    private List<String> getResultByPoints(PreparedStatement ps) {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                result.add(rs.getString("result"));
            }
            return result;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
    }

    public Map<Integer, Integer> getLadybirdsByNumberOfPoints() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select number_of_points as result from ladybirds")){
            return getResultByNumberOfPoints(ps);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }


    }

    private Map<Integer, Integer> getResultByNumberOfPoints(PreparedStatement ps) {

        Map<Integer, Integer> result = new HashMap<>();
        try (ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                int noOfPoints = rs.getInt("result");
                result.merge(noOfPoints, 1, Integer::sum);
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
        return result;
    }

    public Set<Ladybug> getLadybirdByPartOfLatinNameAndNumberOfPoints(String partOfLatinName, int numberOfPoints) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select hungarian_name, latin_name, genus, number_of_points from ladybirds where number_of_points = ? and latin_name like ?")){
            ps.setInt(1, numberOfPoints);
            ps.setString(2, "%" + partOfLatinName + "%");
            return getResultByPointsAndLatinNamePart(ps);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
    }

    private Set<Ladybug> getResultByPointsAndLatinNamePart(PreparedStatement ps) {
        Set<Ladybug> result = new HashSet<>();
        try (ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                result.add(new Ladybug(rs.getString("hungarian_name"),
                        rs.getString("latin_name"),
                        rs.getString("genus"),
                        rs.getInt("number_of_points")));
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
        return result;
    }
}
