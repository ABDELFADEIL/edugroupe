const gulp = require('gulp');
const war = require('gulp-war');
const zip = require('gulp-zip');

gulp.task('war', function (callback) {
  gulp.src(['./asmar/**'])
    .pipe(war({
      welcome: 'index.html',
      displayName: 'asmar',
    }))
    .pipe(zip('asmar.war'))
    .pipe(gulp.dest("./"));
  callback();

});

