package com.borntorun;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class BornToRunRepository implements RunnerRepository {

    @Override
    public List<Runner> findByName(String name) {
        return null;
    }

    @Override
    public Optional<Runner> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<Runner> findByAge(int age) {
        return null;
    }

    @Override
    public List<Runner> findByActive(boolean active) {
        return null;
    }

    @Override
    public List<Runner> findByGender(String gender) {
        return null;
    }

    @Override
    public double calculateAverageAge() {
        return 0;
    }

    @Override
    public Runner findOldestRunner() {
        return null;
    }

    @Override
    public Runner findYoungestRunner() {
        return null;
    }

    @Override
    public List<Runner> search(String keyword) {
        return null;
    }

    @Override
    public List<Runner> findTopNRunners(int topCount) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Runner> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Runner> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Runner> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Runner getOne(Long aLong) {
        return null;
    }

    @Override
    public Runner getById(Long aLong) {
        return null;
    }

    @Override
    public Runner getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Runner> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Runner> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Runner> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Runner> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Runner> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Runner> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Runner, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Runner> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Runner> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Runner> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Runner> findAll() {
        return null;
    }

    @Override
    public List<Runner> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Runner entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Runner> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Runner> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Runner> findAll(Pageable pageable) {
        return null;
    }
}