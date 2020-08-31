/*
 * Copyright (c) 2020 De Staat der Nederlanden, Ministerie van Volksgezondheid, Welzijn en Sport.
 *  Licensed under the EUROPEAN UNION PUBLIC LICENCE v. 1.2
 *
 *  SPDX-License-Identifier: EUPL-1.2
 */
package nl.rijksoverheid.en.config

import nl.rijksoverheid.en.api.CdnService
import nl.rijksoverheid.en.api.model.AppConfig
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

private val DEFAULT_CONFIG = AppConfig()

class AppConfigManager(private val cdnService: CdnService) {

    private suspend fun getConfigOrDefault(block: suspend () -> AppConfig?): AppConfig {
        return try {
            block() ?: DEFAULT_CONFIG
        } catch (ex: HttpException) {
            Timber.w(ex, "Error getting app config, returning default")
            DEFAULT_CONFIG
        } catch (ex: IOException) {
            Timber.w(ex, "Error getting app config, returning default")
            DEFAULT_CONFIG
        }
    }

    /**
     * Get the config or the default config. This may result in network calls.
     * @return the config or the default config if it couldn't be retrieved
     */
    suspend fun getConfigOrDefault(): AppConfig = getConfigOrDefault {
        cdnService.getAppConfig(cdnService.getManifest().appConfigId)
    }

    /**
     * Get the config if previously fetched, or the default config.
     * @return the cached config or the default config.
     */
    suspend fun getCachedConfigOrDefault(): AppConfig = getConfigOrDefault {
        cdnService.getAppConfig(
            cdnService.getManifest("only-if-cached,max-stale=${Int.MAX_VALUE}").appConfigId,
            "only-if-cached,max-stale=${Int.MAX_VALUE}"
        )
    }
}
