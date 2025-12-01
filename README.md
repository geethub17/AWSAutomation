# AWSAutomation

# Selenium Automation Framework with Dockerized Grid & Multi-Browser Support

## 🚀 Project Overview

This project provides a robust **Selenium automation framework** with **Dockerized Selenium Grid** for Chrome and Edge, designed for **parallel execution**, **thread-safe WebDriver management**, and **dynamic reporting**. It supports both **local execution** and **remote execution** on Docker or EC2, with planned Jenkins CI/CD integration.

---

## 🏗️ Features & Status

| Feature                                                             | Status    | Notes                                                  |
| ------------------------------------------------------------------- | --------- | ------------------------------------------------------ |
| Dockerized Selenium Grid (Hub + Chrome + Edge with pinned versions) | ✅ Done    | Chrome 136 + Edge 142 nodes stable                     |
| Test Runner containers for Chrome & Edge                            | ✅ Done    | Separate containers, clean isolation                   |
| DriverManager / ThreadLocal parallel-safe setup                     | ✅ Done    | Multi-browser, multi-threading stable                  |
| Dynamic Cucumber report output per browser                          | ✅ Done    | Edge → `target/edge/...`, Chrome → `target/chrome/...` |
| Logging with Log4j2 (per-browser logs)                              | ✅ Done    | MDC + appender override working                        |
| Extent Reports setup (per-browser spark)                            | ✅ Done    | Required `spark-config.xml` + overrides working        |
| Extent report changes                                               | ✅ Done    | Combine logger and Extent report logs together         |
| Cucumber JSON reports per-browser                                   | ✅ Done    | Both JSONs generated properly                          |
| Jenkins pipeline design                                             | ⏳ Pending | Multi-stage OR parallel stages                         |
| Jenkins + Git webhook for Dev deployment trigger                    | ⏳ Pending | Auto-run after Dev build                               |
| EC2 deployment (Grid + Test Runner infra)                           | ⏳ Pending | Need to create AMI / Docker Compose setup              |
| Hooks for environment setup (dev/stage/prod URL selection)          | ⏳ Pending | Hook-level config + tags                               |
| Local Runner class for quick local execution                        | ✅ Done    | Works without Docker                                   |
| Volume mounts for logs & reports (optional)                         | ⏳ Pending | Useful for EC2 deployments                             |
| POM + Page Object Model implementation                              | ⏳ Pending | Implementation beginning soon                          |

---

## ⚙️ Tech Stack

* **Java** – Core automation code
* **Selenium WebDriver** – Browser automation
* **Cucumber** – BDD framework for readable feature files
* **Docker & Docker Compose** – Grid + Test Runner isolation
* **Log4j2** – Per-browser logging
* **Extent Reports** – Visual test reports per browser
* **Jenkins (Planned)** – CI/CD pipeline for automated execution
* **EC2 (Planned)** – Remote execution infrastructure

---

## 🏃 Usage

### Local Execution

1. Clone the repository:

```bash
git clone <repo-url>
cd automation-framework
```

2. Run the local test runner (without Docker):

```bash
mvn clean test -Dbrowser=chrome
```

### Dockerized Execution

1. Build and start Docker Selenium Grid:

```bash
docker-compose up -d
```

2. Run test containers for Chrome/Edge:

```bash
docker-compose run test-runner-chrome
docker-compose run test-runner-edge
```

3. Reports and logs will be generated in:

* Chrome → `target/chrome/`
* Edge → `target/edge/`

---

## 📁 Folder Structure

```
src/
 ├─ main/
 │   └─ java/                  # Core automation code
 ├─ test/
 │   ├─ java/                  # Step definitions & runner classes
 │   └─ resources/
 │       ├─ features/          # Cucumber feature files
 │       └─ config/            # Browser & environment config
target/
 ├─ chrome/                    # Chrome reports & logs
 └─ edge/                      # Edge reports & logs
docker/
 └─ compose/                   # Docker Compose files for Grid & Test Runners
```

---

## 📊 Reporting

* **Extent Reports** per browser (`target/chrome/`, `target/edge/`)
* **Cucumber JSON reports** for integration with other tools
* **Log4j2 logs** per browser with MDC support

---

## 🔜 Planned Enhancements

* Jenkins multi-stage or parallel pipeline
* Git webhook trigger for auto test execution
* EC2 deployment with Dockerized infrastructure
* Hooks for environment selection (dev/stage/prod)
* Optional volume mounts for persistent logs & reports
* Full Page Object Model (POM) implementation

---

## 📄 Notes

* Ensure your Chrome & Edge versions match the pinned Docker node versions.
* Local execution works independently without Docker.
* Parallel execution is thread-safe using `ThreadLocal` WebDriver management.

---
