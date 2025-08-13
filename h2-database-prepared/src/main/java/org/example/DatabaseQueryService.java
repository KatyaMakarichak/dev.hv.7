package org.example;

import org.example.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private final Connection connection;

    public DatabaseQueryService(Connection connection) {
        this.connection = connection;
    }

    private String readSQL(String fileName) throws IOException {
        return Files.readString(Path.of("src/main/resources/db/" + fileName));
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException, IOException {
        String sql = readSQL("find_max_projects_client.sql");
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            List<MaxProjectCountClient> result = new ArrayList<>();
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    result.add(new MaxProjectCountClient(
                            rs.getString("name"),
                            rs.getInt("project_count")
                    ));
                }
            }
            return result;
        }
    }

    public List<LongestProject> findLongestProject() throws SQLException, IOException {
        String sql = readSQL("find_longest_project.sql");
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            List<LongestProject> result = new ArrayList<>();
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    result.add(new LongestProject(
                            rs.getInt("id"),
                            rs.getInt("month_count")
                    ));
                }
            }
            return result;
        }
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws SQLException, IOException {
        String sql = readSQL("find_max_salary_worker.sql");
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            List<MaxSalaryWorker> result = new ArrayList<>();
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    result.add(new MaxSalaryWorker(
                            rs.getString("name"),
                            rs.getInt("salary")
                    ));
                }
            }
            return result;
        }
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() throws SQLException, IOException {
        String sql = readSQL("find_youngest_eldest_workers.sql");
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            List<YoungestEldestWorker> result = new ArrayList<>();
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    result.add(new YoungestEldestWorker(
                            rs.getString("type"),
                            rs.getString("name"),
                            rs.getDate("birthday").toLocalDate()
                    ));
                }
            }
            return result;
        }
    }

    public List<ProjectPrice> printProjectPrices() throws SQLException, IOException {
        String sql = readSQL("print_project_prices.sql");
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            List<ProjectPrice> result = new ArrayList<>();
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    result.add(new ProjectPrice(
                            rs.getInt("project_id"),
                            rs.getInt("price")
                    ));
                }
            }
            return result;
        }
    }
}
