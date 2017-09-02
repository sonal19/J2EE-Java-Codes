package com.nagarro.flightdemo.threads;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.HashMap;

import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.presentation.UserInput;
import com.nagarro.flightdemo.utils.CSVReaders;

/**
 * The Class DirectoryWatcher.
 */
public class DirectoryWatcher {

	/**
	 * Directory watch.
	 *
	 * @param path
	 *            the path
	 * @param fileMapper
	 *            the file mapper stores the value of csv files in key value
	 *            pair where key is the name of the file
	 * @return the hash map
	 */
	public static HashMap<String, ArrayList<FlightDetails>> directoryWatch(final String path,
			final HashMap<String, ArrayList<FlightDetails>> fileMapper) {

		try {
			final WatchService watcher = FileSystems.getDefault().newWatchService();
			final Path directory = Paths.get(path);
			directory.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

			while (true) {
				WatchKey key = null;
				try {
					key = watcher.take();
				} catch (final InterruptedException ex) {
					// return;
				}

				for (final WatchEvent<?> event : key.pollEvents()) {
					final WatchEvent.Kind<?> kind = event.kind();

					@SuppressWarnings("unchecked")
					final WatchEvent<Path> watchEvent = (WatchEvent<Path>) event;
					final Path fileName = watchEvent.context();

					if (kind == ENTRY_CREATE || kind == ENTRY_MODIFY) {
						System.gc();
						fileMapper.put(fileName.toString(), CSVReaders.readCSVFile(fileName.toString()));

					} else if (kind == ENTRY_DELETE) {
						System.gc();
						fileMapper.remove(fileName.toString());
					}
				}

				final boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}

		} catch (final IOException ex) {
			UserInput.LOGGER.debug(ex);
		}

		return fileMapper;
	}
}
