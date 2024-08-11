/*
 * Copyright (c) 2011-2014 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *     The Eclipse Public License is available at
 *     http://www.eclipse.org/legal/epl-v10.html
 *
 *     The Apache License v2.0 is available at
 *     http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */
package io.vertx.jdbcclient;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.json.annotations.JsonGen;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.tracing.TracingPolicy;
import io.vertx.sqlclient.SqlConnectOptions;

@DataObject
@JsonGen(publicConverter = false)
public class JDBCConnectOptions extends SqlOptions {

  private String dataSourceImplementation = "AGROAL";
  private boolean metricsEnabled;
  private String jdbcUrl;
  private String user;
  private String password;
  private String database;
  private int connectTimeout = 60000;
  private int idleTimeout;
  private TracingPolicy tracingPolicy = TracingPolicy.PROPAGATE;
  private JsonObject extraConfig;
  private String metricsName = "";

  public JDBCConnectOptions() {}

  public JDBCConnectOptions(JsonObject json) {
    JDBCConnectOptionsConverter.fromJson(json, this);
  }

  public JDBCConnectOptions(JDBCConnectOptions other) {
    super(other);
    this.dataSourceImplementation = other.dataSourceImplementation;
    this.metricsEnabled = other.metricsEnabled;
    this.jdbcUrl = other.jdbcUrl;
    this.user = other.user;
    this.password = other.password;
    this.database = other.database;
    this.connectTimeout = other.connectTimeout;
    this.idleTimeout = other.idleTimeout;
    this.tracingPolicy = other.tracingPolicy;
    this.extraConfig = other.extraConfig != null ? other.extraConfig.copy() : null;
    this.metricsName = other.metricsName;
  }

  public String getDataSourceImplementation() {
    return dataSourceImplementation;
  }

  public JDBCConnectOptions setDataSourceImplementation(String dataSourceImplementation) {
    this.dataSourceImplementation = dataSourceImplementation;
    return this;
  }

  public boolean isMetricsEnabled() {
    return metricsEnabled;
  }

  public JDBCConnectOptions setMetricsEnabled(boolean metricsEnabled) {
    this.metricsEnabled = metricsEnabled;
    return this;
  }

  public String getJdbcUrl() {
    return jdbcUrl;
  }

  public JDBCConnectOptions setJdbcUrl(String jdbcUrl) {
    this.jdbcUrl = jdbcUrl;
    return this;
  }

  public String getUser() {
    return user;
  }

  public JDBCConnectOptions setUser(String user) {
    this.user = user;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public JDBCConnectOptions setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getDatabase() {
    return database;
  }

  public JDBCConnectOptions setDatabase(String database) {
    this.database = database;
    return this;
  }

  public int getConnectTimeout() {
    return connectTimeout;
  }

  public JDBCConnectOptions setConnectTimeout(int connectTimeout) {
    this.connectTimeout = connectTimeout;
    return this;
  }

  public int getIdleTimeout() {
    return idleTimeout;
  }

  public JDBCConnectOptions setIdleTimeout(int idleTimeout) {
    this.idleTimeout = idleTimeout;
    return this;
  }

  /**
   * @return the metrics name identifying the reported metrics.
   */
  public String getMetricsName() {
    return metricsName;
  }

  /**
   * Set the metrics name identifying the reported metrics, useful for grouping metrics
   * with the same name.
   *
   * @param metricsName the metrics name
   * @return a reference to this, so the API can be used fluently
   */
  public JDBCConnectOptions setMetricsName(String metricsName) {
    this.metricsName = metricsName;
    return this;
  }

  /**
   * @return the tracing policy
   */
  public TracingPolicy getTracingPolicy() {
    return tracingPolicy;
  }

  /**
   * Set the tracing policy for the client behavior when Vert.x has tracing enabled.
   *
   * @param tracingPolicy the tracing policy
   * @return a reference to this, so the API can be used fluently
   */
  public JDBCConnectOptions setTracingPolicy(TracingPolicy tracingPolicy) {
    this.tracingPolicy = tracingPolicy;
    return this;
  }

  public JsonObject getExtraConfig() {
    return extraConfig;
  }

  public JDBCConnectOptions setExtraConfig(JsonObject extraConfig) {
    this.extraConfig = extraConfig;
    return this;
  }

  // overrides

  @Override
  public JDBCConnectOptions setReadOnly(boolean readOnly) {
    super.setReadOnly(readOnly);
    return this;
  }

  @Override
  public JDBCConnectOptions setCatalog(String catalog) {
    super.setCatalog(catalog);
    return this;
  }

  @Override
  public JDBCConnectOptions setTransactionIsolation(TransactionIsolation transactionIsolation) {
    super.setTransactionIsolation(transactionIsolation);
    return this;
  }

  @Override
  public JDBCConnectOptions setResultSetType(ResultSetType resultSetType) {
    super.setResultSetType(resultSetType);
    return this;
  }

  @Override
  public JDBCConnectOptions setResultSetConcurrency(ResultSetConcurrency resultSetConcurrency) {
    super.setResultSetConcurrency(resultSetConcurrency);
    return this;
  }

  @Override
  public JDBCConnectOptions setAutoGeneratedKeys(boolean autoGeneratedKeys) {
    super.setAutoGeneratedKeys(autoGeneratedKeys);
    return this;
  }

  @Override
  public JDBCConnectOptions setSchema(String schema) {
    super.setSchema(schema);
    return this;
  }

  @Override
  public JDBCConnectOptions setQueryTimeout(int queryTimeout) {
    super.setQueryTimeout(queryTimeout);
    return this;
  }

  @Override
  public JDBCConnectOptions setFetchDirection(FetchDirection fetchDirection) {
    super.setFetchDirection(fetchDirection);
    return this;
  }

  @Override
  public JDBCConnectOptions setFetchSize(int fetchSize) {
    super.setFetchSize(fetchSize);
    return this;
  }

  @Override
  public JDBCConnectOptions setAutoGeneratedKeysIndexes(JsonArray autoGeneratedKeysIndexes) {
    super.setAutoGeneratedKeysIndexes(autoGeneratedKeysIndexes);
    return this;
  }

  @Override
  public JDBCConnectOptions setMaxRows(int maxRows) {
    super.setMaxRows(maxRows);
    return this;
  }

  public JsonObject toJson() {
    final JsonObject json = new JsonObject();
    JDBCConnectOptionsConverter.toJson(this, json);
    return json;
  }
}
